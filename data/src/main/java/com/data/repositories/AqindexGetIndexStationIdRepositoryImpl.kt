package com.data.repositories

import com.data.client.api.AirQualityApi
import com.domain.entities.model.AqindexGetIndexStationId
import com.domain.repositories.AqIndexGetIndexStationIdRepository
import io.reactivex.Single

class AqindexGetIndexStationIdRepositoryImpl(
    private val airQualityApi: AirQualityApi
) : AqIndexGetIndexStationIdRepository {
    override fun get(stationId: Int): Single<AqindexGetIndexStationId> {
        return airQualityApi.apiAqindexGetIndexStationId(stationId)
    }

}