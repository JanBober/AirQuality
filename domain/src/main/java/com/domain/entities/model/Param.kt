package com.domain.entities.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class Param(
    @field:SerializedName("paramName")
    var paramName: String? = null,

    @field:SerializedName("paramFormula")
    var paramFormula: String? = null,

    @field:SerializedName("paramCode")
    var paramCode: String? = null,

    @field:SerializedName("idParam")
    var idParam: Int? = null
) {
}