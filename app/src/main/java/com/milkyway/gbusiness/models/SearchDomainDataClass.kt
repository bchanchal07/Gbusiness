package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class SearchDomainDataClass(
    @SerializedName("status")
    val status: String,
    @SerializedName("result")
    val result: String,
    @SerializedName("whois")
    val whois: String
)