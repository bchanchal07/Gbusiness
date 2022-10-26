package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class demo(
    @SerializedName("result")
    val result: Result,
    @SerializedName("status")
    val status: String
) {
    data class Result(
        @SerializedName("msg")
        val msg: String
    )
}