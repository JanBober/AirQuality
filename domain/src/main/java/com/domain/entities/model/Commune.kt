package com.domain.entities.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class Commune(
    @field:SerializedName("communeName")
    var communeName: String? = null,

    @field:SerializedName("districtName")
    var districtName: String? = null,

    @field:SerializedName("provinceName")
    var provinceName: String? = null
) {
}