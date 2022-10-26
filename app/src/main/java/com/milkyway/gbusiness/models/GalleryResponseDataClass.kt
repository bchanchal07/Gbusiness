package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class GalleryResponseDataClass(
    val `data`: List<Data>,
    val message: String, // Data fetched Successfully!
    val success: Boolean, // true
) {
    data class Data(
        val id: Int, // 36
        @SerializedName("user_id")
        val userId: String, // 408
        @SerializedName("business_id")
        val businessId: String, // 225
        val name: String, // Cure Natural Skin Care
        @SerializedName("gallery_image")
        val galleryImage: String, // Dead-Salt.jpg
        @SerializedName("created_at")
        val createdAt: String, // null
        @SerializedName("updated_at")
        val updatedAt: String, // null
        val imageList: List<ImageList>,

        ) {
        data class ImageList(
            val image: String,
        )
    }
}