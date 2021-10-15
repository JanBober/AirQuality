package com.domain.entities.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class City(
    @field:SerializedName("id")
    var id: Int? = null,

    @field:SerializedName("name")
    var name: String? = null,

    @field:SerializedName("commune")
    var commune: Commune? = null
) {
}