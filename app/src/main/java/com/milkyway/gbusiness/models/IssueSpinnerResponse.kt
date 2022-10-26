package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class IssueSpinnerResponse(
    val `data`: List<Data>,
    val message: String, // Data fetched Successfully!
    val success: Boolean // true
) {
    data class Data(
        @SerializedName("created_at")
        val createdAt: String, // 2019-07-01T15:56:11.000000Z
        val id: Int, // 10
        val name: String, // Global Earning
        @SerializedName("updated_at")
        val updatedAt: String // 2019-07-01T15:56:11.000000Z
    )
}