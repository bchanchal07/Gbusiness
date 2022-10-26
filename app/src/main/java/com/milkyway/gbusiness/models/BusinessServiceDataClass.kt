package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class BusinessServiceDataClass(
    val `data`: List<Data>,
    val message: String, // Data fetched Successfully!
    val success: Boolean // true
) {
    data class Data(
        @SerializedName("created_at")
        val createdAt: String, // 0000-00-00 00:00:00
        val id: Int, // 1
        val name: String, // Abbey
        val slug: String, // abbey
        @SerializedName("updated_at")
        val updatedAt: String // 0000-00-00 00:00:00
    )
}