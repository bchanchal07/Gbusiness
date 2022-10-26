package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class GetBusinessDataClass(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: String
) {
    data class Data(
        @SerializedName("avatar")
        val avatar: String,
        @SerializedName("business_about_us")
        val businessAboutUs: String,
        @SerializedName("business_email")
        val businessEmail: String,
        @SerializedName("business_logo")
        val businessLogo: String,
        @SerializedName("business_web_url")
        val businessWebUrl: String,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("mime_type")
        val mimeType: String,
        @SerializedName("profession")
        val profession: String,
        @SerializedName("size")
        val size: Any,
        @SerializedName("updated_at")
        val updatedAt: String,
        @SerializedName("user_id")
        val userId: Int,
        @SerializedName("user_name")
        val userName: String
    )
}