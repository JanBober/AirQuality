package com.domain.repositories

import com.domain.entities.model.StationSensorsStationId
import io.reactivex.Single

interface StationSensorsStationIdRepository {

    fun get(stationId: Int): Single<List<StationSensorsStationId>>
}