package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class BusinessHrsDataClass(
    val code: Int, // 200
    val `data`: List<HrsData>,
    val msg: String, // Data fetched Successfully
) {
    data class HrsData(
        @SerializedName("days")
        val days: String,
        @SerializedName("start_time")
        val startTime: String,
        @SerializedName("end_time")
        val endTime: String,

        )
}