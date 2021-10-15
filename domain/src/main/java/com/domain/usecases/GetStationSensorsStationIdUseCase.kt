package com.domain.usecases

import com.domain.entities.model.StationSensorsStationId
import com.domain.repositories.StationSensorsStationIdRepository
import io.reactivex.Single

class GetStationSensorsStationIdUseCase(
    private val stationSensorsStationIdRepository: StationSensorsStationIdRepository
    ) {

    fun execute(stationId: Int): Single<List<StationSensorsStationId>> {
        return stationSensorsStationIdRepository.get(stationId)
    }
}