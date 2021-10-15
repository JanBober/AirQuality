package com.data.repositories

import com.data.client.api.AirQualityApi
import com.domain.entities.model.Root
import com.domain.repositories.FindAllRepository
import io.reactivex.Single

class FindAllRepositoryImpl(private val airQualityApi: AirQualityApi) : FindAllRepository {

    override fun get(): Single<List<Root>> {
        return airQualityApi.apiAirQualityGet()
    }

}