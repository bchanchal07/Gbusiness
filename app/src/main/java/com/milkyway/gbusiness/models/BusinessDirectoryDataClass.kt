package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class BusinessDirectoryDataClass(
    val `data`: List<Data>,
    val message: String, // Business Listing Successfully !
    val success: Boolean // true
) {
    data class Data(
        val address: String, // H No 89, Gali No 1, Main Shyampark Metro Station, Near Sahibabad Police Station, Sahihabad 201005
        @SerializedName("business_about_us")
        val businessAboutUs: String, // about us
        @SerializedName("business_email")
        val businessEmail: String, // vinod.milkywayinfotech@gmail.com
        @SerializedName("business_logo")
        val businessLogo: String, // 1650260175-d645920e395fedad7bbbed0eca3fe2e0.jpg
        @SerializedName("business_name")
        val businessName: String, // Android App
        @SerializedName("business_phone")
        val businessPhone: String, // 09540381085
        @SerializedName("business_services")
        val businessServices: String, // null
        @SerializedName("business_services_other")
        val businessServicesOther: String, // null
        @SerializedName("business_type")
        val businessType: String, // My Self
        @SerializedName("business_web_url")
        val businessWebUrl: String, // http://www.testurl.com
        @SerializedName("category_id")
        val categoryId: Int, // 29
        val catname: String, // IT services
        val city: String, // Ghaziabad
        @SerializedName("country_id")
        val countryId: Int, // 101
        @SerializedName("created_at")
        val createdAt: String, // 2022-05-04 11:16:46
        @SerializedName("establish_date")
        val establishDate: String, // null
        @SerializedName("facebook_url")
        val facebookUrl: String, // null
        val friday: String, // null
        @SerializedName("friday_end_time")
        val fridayEndTime: String, // null
        @SerializedName("friday_start_time")
        val fridayStartTime: String, // null
        val id: Int, // 216
        @SerializedName("instagram_url")
        val instagramUrl: String, // null
        @SerializedName("linkedin_url")
        val linkedinUrl: String, // null
        val monday: String, // null
        @SerializedName("monday_end_time")
        val mondayEndTime: String, // null
        @SerializedName("monday_start_time")
        val mondayStartTime: String, // null
        val saturday: String, // null
        @SerializedName("saturday_end_time")
        val saturdayEndTime: String, // null
        @SerializedName("saturday_start_time")
        val saturdayStartTime: String, // null
        @SerializedName("seller_url")
        val sellerUrl: String,
        val sponsor: Int, // 0
        @SerializedName("state_id")
        val stateId: Int, // 4029
        val status: Int, // 1
        @SerializedName("sub_category_id")
        val subCategoryId: Int, // 757
        @SerializedName("sub_domain")
        val subDomain: String, // it
        val subcatname: String, // IT Administration and Architecture Training
        val sunday: String, // null
        @SerializedName("sunday_end_time")
        val sundayEndTime: String, // null
        @SerializedName("sunday_start_time")
        val sundayStartTime: String, // null
        val thirsday: String, // null
        @SerializedName("thirsday_end_time")
        val thirsdayEndTime: String, // null
        @SerializedName("thirsday_start_time")
        val thirsdayStartTime: String, // null
        val tuesday: String, // null
        @SerializedName("tuesday_end_time")
        val tuesdayEndTime: String, // null
        @SerializedName("tuesday_start_time")
        val tuesdayStartTime: String, // null
        @SerializedName("twitter_url")
        val twitterUrl: String, // null
        @SerializedName("updated_at")
        val updatedAt: String, // 2022-04-18 11:06:15
        @SerializedName("url_slug")
        val urlSlug: String, // android-app
        @SerializedName("user_id")
        val userId: Int, // 40
        val wednesday: String, // null
        @SerializedName("wednesday_end_time")
        val wednesdayEndTime: String, // null
        @SerializedName("wednesday_start_time")
        val wednesdayStartTime: String, // null
        @SerializedName("zip_code")
        val zipCode: Int // 201005
    )
}