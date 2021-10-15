package com.domain.entities.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class Pm10IndexLevel(
    @field:SerializedName("id")
    var id: Int? = null,
    @field:SerializedName("indexLevelName")
    var indexLevelName: String? = null
) {
}