package com.taskailleronjanbober.screens.main

import androidx.lifecycle.MutableLiveData
import com.domain.entities.model.AirQualityState
import com.domain.entities.model.AqindexGetIndexStationId
import com.domain.entities.model.Root
import com.domain.entities.model.StationSensorsStationId
import com.domain.usecases.GetAqindexGetIndexStationIdUseCase
import com.domain.usecases.GetFindAllUseCase
import com.domain.usecases.GetStationSensorsStationIdUseCase
import com.taskailleronjanbober.base.BaseViewModel
import com.taskailleronjanbober.base.SingleLiveEvent
import com.taskailleronjanbober.base.ktx.mutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getFindAllUseCase: GetFindAllUseCase,
    private val getStationSensorsStationIdUseCase: GetStationSensorsStationIdUseCase,
    private val aqIndexGetIndexStationIdUseCase: GetAqindexGetIndexStationIdUseCase
) : BaseViewModel() {

    val action = SingleLiveEvent<Action>()
    val error = SingleLiveEvent<Errors>()
    val airQualityState = MutableLiveData<AirQualityState>()
    val city = mutableLiveData("")

    fun back() {
        action.value = Action.Back
    }

    fun repositoryClicked(airQualityState: AirQualityState) {
        this.airQualityState.value = airQualityState
        city.value = airQualityState.city
        action.value = Action.GoToFormItemFlipper
        airQualityState.id?.let { fetchStationSensorsStationId(it) }
    }

    fun fetchFindAllApi() {
        getFindAllUseCase
            .execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    readDataStation(it)
                },
                onError = {
                    error.value = Errors.ErrorException(it)
                }
            ).addTo(disposables)
    }

    fun readDataStation(listStation: List<Root>) {
        listStation.forEach { station ->
            station.id?.let {
                station.stationName?.let { it1 ->
                    fetchAqIndexGetIndexStationId(
                        it,
                        it1
                    )
                }
            }
        }
    }

    fun fetchStationSensorsStationId(stationId: Int) {
        getStationSensorsStationIdUseCase
            .execute(stationId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    action.value = Action.DownloadStationSensorsStationId(it)
                },
                onError = {
                    error.value = Errors.ErrorException(it)
                }
            ).addTo(disposables)
    }

    fun fetchAqIndexGetIndexStationId(stationId: Int, city: String) {
        aqIndexGetIndexStationIdUseCase
            .execute(stationId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    mapToAirQualityState(it,city)
                },
                onError = {
                    error.value = Errors.ErrorException(it)
                }
            ).addTo(disposables)
    }

    fun mapToAirQualityState(aqIndexGetIndexStationId: AqindexGetIndexStationId, cityName: String) {
        val airQualityState = AirQualityState().apply {

            id = aqIndexGetIndexStationId.id
            city = cityName
            stIndexLevel = when {
                aqIndexGetIndexStationId.stIndexLevel == null -> -1
                aqIndexGetIndexStationId.stIndexLevel.id == null -> -1
                else -> aqIndexGetIndexStationId.stIndexLevel.id
            }
            so2IndexLevel = when {
                aqIndexGetIndexStationId.so2IndexLevel == null -> -1
                aqIndexGetIndexStationId.so2IndexLevel.id == null -> -1
                else -> aqIndexGetIndexStationId.so2IndexLevel.id
            }

            no2IndexLevel = when {
                aqIndexGetIndexStationId.no2IndexLevel == null -> -1
                aqIndexGetIndexStationId.no2IndexLevel.id == null -> -1
                else -> aqIndexGetIndexStationId.no2IndexLevel.id
            }
            pm10IndexLevel = when {
                aqIndexGetIndexStationId.pm10IndexLevel == null -> -1
                aqIndexGetIndexStationId.pm10IndexLevel.id == null -> -1
                else -> aqIndexGetIndexStationId.pm10IndexLevel.id
            }
            pm25IndexLevel = when {
                aqIndexGetIndexStationId.pm25IndexLevel == null -> -1
                aqIndexGetIndexStationId.pm25IndexLevel.id == null -> -1
                else -> aqIndexGetIndexStationId.pm25IndexLevel.id
            }
            o3IndexLevel = when {
                aqIndexGetIndexStationId.o3IndexLevel == null -> -1
                aqIndexGetIndexStationId.o3IndexLevel.id == null -> -1
                else -> aqIndexGetIndexStationId.o3IndexLevel.id
            }
        }
        action.value = Action.DownloadAqIndexGetIndexStationId(airQualityState)
    }

    sealed class Action {
        data class DownloadStationSensorsStationId(
            val stationSensorsStationId: List<StationSensorsStationId>
        ) : Action()

        data class DownloadAqIndexGetIndexStationId(
            val airQualityState: AirQualityState
        ) : Action()

        object GoToFormItemFlipper : Action()
        object Back : Action()
    }

    sealed class Errors {
        data class ErrorException(val exception: Throwable) : Errors()
    }
}