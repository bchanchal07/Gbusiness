package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class DomainPricingDataClass(
    @SerializedName("currency")
    val currency: Currency,
    @SerializedName("result")
    val result: String,
) {
    data class Currency(
        @SerializedName("code")
        val code: String,
        @SerializedName("format")
        val format: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("prefix")
        val prefix: String,
        @SerializedName("rate")
        val rate: String,
        @SerializedName("suffix")
        val suffix: String,
    )
}