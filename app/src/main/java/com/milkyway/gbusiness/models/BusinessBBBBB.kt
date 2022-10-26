package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class BusinessBBBBB(
    val `data`: List<Data>,
    val message: String, // Data Fetched Successfully!
    val success: Boolean // true
) {
    data class Data(
        val address: String, // Al Fatima Building, Office no M05, Al Muteena Area Daira Dubai UAE , P.O Box no 150420
        @SerializedName("business_about_us")
        val businessAboutUs: String, // We, WISH SURGICAL, have been the leading suppliers and manufacturers of a wide variety of top-quality surgical instruments since 2000. Centrally controlled by offices in Sialkot (51310), we are a widespread network dealing our products worldwide at the most competitive prices.
        @SerializedName("business_email")
        val businessEmail: String, // info@wishsurgical.com
        @SerializedName("business_logo")
        val businessLogo: String, // 1649954288-05049e90fa4f5039a8cadc6acbb4b2cc.jpg
        @SerializedName("business_name")
        val businessName: String, // wishsurgical
        @SerializedName("business_phone")
        val businessPhone: String, // +971 0555445409
        @SerializedName("business_type")
        val businessType: String, // My Self
        @SerializedName("business_web_url")
        val businessWebUrl: String, // http://wishsurgical.com/
        @SerializedName("category_id")
        val categoryId: Int, // 2
        val city: String, // Al Muteena Area Daira Dubai
        @SerializedName("country_id")
        val countryId: Int, // 229
        @SerializedName("created_at")
        val createdAt: String, // 2022-04-14T16:38:08.000000Z
        @SerializedName("facebook_url")
        val facebookUrl: String, // https://www.facebook.com/WishSurgical
        val id: Int, // 206
        @SerializedName("instagram_url")
        val instagramUrl: String, // https://www.facebook.com/WishSurgical
        @SerializedName("linkedin_url")
        val linkedinUrl: String, // https://www.linkedin.com/in/adnan-arshad-7abb6a85/
        @SerializedName("seller_url")
        val sellerUrl: String,
        @SerializedName("state_id")
        val stateId: Int, // 3798
        val status: Int, // 1
        @SerializedName("sub_category_id")
        val subCategoryId: Int, // 30
        @SerializedName("sub_domain")
        val subDomain: String, // httpwishsurgicalcom
        @SerializedName("twitter_url")
        val twitterUrl: Any, // null
        @SerializedName("updated_at")
        val updatedAt: String, // 2022-04-14T16:38:08.000000Z
        @SerializedName("url_slug")
        val urlSlug: String, // wishsurgical
        @SerializedName("user_id")
        val userId: Int, // 367
        @SerializedName("zip_code")
        val zipCode: Int // 150420
    )
}