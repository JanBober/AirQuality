package com.domain.entities.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class AqindexGetIndexStationId(
    @field:SerializedName("id")
    var id: Int,
    @field:SerializedName("stCalcDate")
    var stCalcDate: String,
    @field:SerializedName("stIndexLevel")
    var stIndexLevel: StIndexLevel,
    @field:SerializedName("stSourceDataDate")
    var stSourceDataDate: String,
    @field:SerializedName("so2CalcDate")
    var so2CalcDate: String,
    @field:SerializedName("so2IndexLevel")
    var so2IndexLevel: So2IndexLevel,
    @field:SerializedName("so2SourceDataDate")
    var so2SourceDataDate: String,
    @field:SerializedName("no2CalcDate")
    var no2CalcDate: String,
    @field:SerializedName("no2IndexLevel")
    var no2IndexLevel: No2IndexLevel,
    @field:SerializedName("no2SourceDataDate")
    var no2SourceDataDate: String,
    @field:SerializedName("pm10CalcDate")
    var pm10CalcDate: String,
    @field:SerializedName("pm10IndexLevel")
    var pm10IndexLevel: Pm10IndexLevel,
    @field:SerializedName("pm10SourceDataDate")
    var pm10SourceDataDate: String,
    @field:SerializedName("pm25CalcDate")
    var pm25CalcDate: String,
    @field:SerializedName("pm25IndexLevel")
    var pm25IndexLevel: Pm25IndexLevel,
    @field:SerializedName("pm25SourceDataDate")
    var pm25SourceDataDate: String,
    @field:SerializedName("o3CalcDate")
    var o3CalcDate: String,
    @field:SerializedName("o3IndexLevel")
    var o3IndexLevel: O3IndexLevel,
    @field:SerializedName("o3SourceDataDate")
    var o3SourceDataDate: String,
    @field:SerializedName("stIndexStatus")
    var stIndexStatus: Boolean,
    @field:SerializedName("stIndexCrParam")
    var stIndexCrParam: String,
) {
}