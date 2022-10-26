package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BusinessListingResponse(
    val data: List<Data> = ArrayList(),
    val message: String, // Business Listing Successfully !
    val success: Boolean // true
) {
    data class Data(
        @SerializedName("business_about_us")
        val businessAboutUs: String, // Test
        @SerializedName("business_email")
        val businessEmail: String, // vinod@milkywayservices.com
        @SerializedName("business_logo")
        val businessLogo: String, // default-business-logo.jpg
        @SerializedName("business_name")
        val businessName: String, // abc
        @SerializedName("business_type")
        val businessType: String, // subdomain
        @SerializedName("business_web_url")
        val businessWebUrl: String, // https://abc.gbusiness.co
        @SerializedName("category_id")
        val categoryId: Int, // 42
        val catname: String, // Schools
        @SerializedName("created_at")
        val createdAt: String, // 2022-01-15 00:00:00
        val id: Int, // 2
        val status: Int, // 1
        @SerializedName("sub_category_id")
        val subCategoryId: Int, // 937
        val subcatname: String, // CBSE Schools
        @SerializedName("updated_at")
        val updatedAt: String, // null
        @SerializedName("user_id")
        val userId: Int // 1364
    ) : Serializable
}