package com.domain.repositories

import com.domain.entities.model.AqindexGetIndexStationId
import io.reactivex.Single

interface AqIndexGetIndexStationIdRepository {

    fun get(stationId: Int): Single<AqindexGetIndexStationId>
}