package com.domain.entities.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class Root(
    @field:SerializedName("id")
    var id: Int? = null,

    @field:SerializedName("stationName")
    var stationName: String? = null,

    @field:SerializedName("gegrLat")
    var gegrLat: String? = null,

    @field:SerializedName("gegrLon")
    var gegrLon: String? = null,

    @field:SerializedName("city")
    var city: City? = null,

    @field:SerializedName("addressStreet")
    var addressStreet: String? = null
) {
}