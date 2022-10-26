package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class AddReviewsDataClass(
    val `data`: Data,
    val message: String, // Review & Ratting add Successfully!
    val success: Boolean // true
) {
    data class Data(
        val comments: String, // This training is very usefull.
        @SerializedName("created_at")
        val createdAt: String, // 2022-05-16T05:13:03.000000Z
        val email: String, // vinod@milkywayinfotech.in
        val id: Int, // 27
        val name: String, // Vinod
        val phone: String, // 9540381085
        @SerializedName("post_id")
        val postId: String, // 365
        @SerializedName("star_rating")
        val starRating: String, // 5.0
        @SerializedName("updated_at")
        val updatedAt: String // 2022-05-16T05:13:03.000000Z
    )
}