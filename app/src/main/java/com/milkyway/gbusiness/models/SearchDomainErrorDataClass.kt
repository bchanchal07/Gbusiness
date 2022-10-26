package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class SearchDomainErrorDataClass(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: String
)