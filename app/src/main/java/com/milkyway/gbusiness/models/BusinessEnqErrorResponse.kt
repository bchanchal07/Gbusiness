package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class BusinessEnqErrorResponse(
    @SerializedName("result")
    val result: Result,
    @SerializedName("status")
    val status: String
) {
    data class Result(
        @SerializedName("email_error")
        val emailError: String,
        @SerializedName("mobile_number_error")
        val mobileNumberError: String,
        @SerializedName("name_error")
        val nameError: String,
        @SerializedName("query_error")
        val queryError: String
    )
}