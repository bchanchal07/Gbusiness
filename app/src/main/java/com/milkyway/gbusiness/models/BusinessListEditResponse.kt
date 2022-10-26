package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class BusinessListEditResponse(
    val `data`: Data,
    val message: String, // Business Details Updated Successfully
    val success: Boolean // true
) {
    data class Data(
        @SerializedName("business_about_us")
        val businessAboutUs: String, // This is the test webservices.
        @SerializedName("business_email")
        val businessEmail: String, // info@xyz.in
        @SerializedName("business_logo")
        val businessLogo: String, // effc299a1addb07e7089f9b269c31f2f.png
        @SerializedName("business_name")
        val businessName: String, // IT Professional
        @SerializedName("business_web_url")
        val businessWebUrl: String, // https://www.abc.in/
        @SerializedName("category_id")
        val categoryId: String, // 9
        @SerializedName("sub_category_id")
        val subCategoryId: String // 175
    )
}