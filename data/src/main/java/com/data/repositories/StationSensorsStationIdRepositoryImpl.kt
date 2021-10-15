package com.data.repositories

import com.data.client.api.AirQualityApi
import com.domain.entities.model.StationSensorsStationId
import com.domain.repositories.StationSensorsStationIdRepository
import io.reactivex.Single

class StationSensorsStationIdRepositoryImpl(
    private val airQualityApi: AirQualityApi
    ) : StationSensorsStationIdRepository {

    override fun get(stationId: Int): Single<List<StationSensorsStationId>> {
        return airQualityApi.apiSensorsStationId(stationId)
    }
}