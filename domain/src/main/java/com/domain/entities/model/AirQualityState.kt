package com.domain.entities.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
class AirQualityState(
    @field:SerializedName("id")
    var id: Int? = null,

    @field:SerializedName("city")
    var city: String? = null,

    @field:SerializedName("stIndexLevel")
    var stIndexLevel: Int? = null,

    @field:SerializedName("so2IndexLevel")
    var so2IndexLevel: Int? = null,

    @field:SerializedName("no2IndexLevel")
    var no2IndexLevel: Int? = null,

    @field:SerializedName("pm10IndexLevel")
    var pm10IndexLevel: Int? = null,

    @field:SerializedName("pm25IndexLevel")
    var pm25IndexLevel: Int? = null,

    @field:SerializedName("o3IndexLevel")
    var o3IndexLevel: Int? = null

) : Serializable {
}