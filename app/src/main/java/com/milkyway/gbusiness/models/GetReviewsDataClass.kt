package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class GetReviewsDataClass(
    val `data`: List<Data>,
    val message: String, // Data Fetched Successfully!
    val success: Boolean, // true
) {
    data class Data(
        val comments: String, // Better
        @SerializedName("created_at")
        val createdAt: String, // 2022-05-17 12:00:47
        val email: String, // abc@gmail.com
        val id: Int, // 34
        val name: String, // vinod
        val phone: String, // 9540381085
        @SerializedName("post_id")
        val postId: Int, // 365
        @SerializedName("star_rating")
        val starRating: Int, // 4
        @SerializedName("updated_at")
        val updatedAt: String, // 2022-05-17 12:00:47
    )
}