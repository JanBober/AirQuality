package com.domain.usecases

import com.domain.entities.model.AqindexGetIndexStationId
import com.domain.repositories.AqIndexGetIndexStationIdRepository
import io.reactivex.Single

class GetAqindexGetIndexStationIdUseCase(
    private val aqIndexGetIndexStationIdRepository: AqIndexGetIndexStationIdRepository
) {

    fun execute(stationId: Int): Single<AqindexGetIndexStationId> {
        return aqIndexGetIndexStationIdRepository.get(stationId)
    }
}