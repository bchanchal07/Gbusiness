package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class ReviewsResponseDataClass(
    val code: Int, // 200
    val `data`: List<Data>,
    val msg: String // Data feteched Successfully
) {
    data class Data(
        val id: Int, // 1
        @SerializedName("user_name")
        val userName: String, // Daniel Vittory
        @SerializedName("user_email")
        val userEmail: String, // danielv@gmail.com
        val rating: String, // 3.5
        @SerializedName("review_comment")
        val reviewComment: String, // This is the best serives as compare to other services.
        val image: String, // null

    )
}