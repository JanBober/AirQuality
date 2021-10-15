package com.data.client.api

import com.domain.entities.model.AqindexGetIndexStationId
import com.domain.entities.model.Root
import com.domain.entities.model.StationSensorsStationId
import io.reactivex.Single
import retrofit2.http.*

interface AirQualityApi {

    @GET("station/findAll")
    fun apiAirQualityGet(): Single<List<Root>>

    @GET("station/sensors/{stationId}")
    fun apiSensorsStationId(
        @Path("stationId") id: Int
    ): Single<List<StationSensorsStationId>>

    @GET("aqindex/getIndex/{stationId}")
    fun apiAqindexGetIndexStationId(
        @Path("stationId") id: Int
    ): Single<AqindexGetIndexStationId>

}