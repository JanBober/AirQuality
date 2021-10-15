package com.domain.entities.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class StationSensorsStationId(
    @field:SerializedName("id")
    var id: Int? = null,

    @field:SerializedName("stationId")
    var stationId: Int? = null,

    @field:SerializedName("param")
    var param: Param? = null
) {
}