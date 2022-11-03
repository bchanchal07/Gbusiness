package com.milkyway.gbusiness.models

data class BusinessListEditResponse(
    val `data`: Data,
    val message: String,
    val success: Boolean,
) {
    data class Data(
        val user_id: String,
        val business_about_us: String,
        val business_email: String,
        val business_logo: String,
        val business_name: String,
        val url_slug: String,
        val sub_domain: String,
        val business_phone: String,
        val business_web_url: String,
        val category_id: String,
        val sub_category_id: String,
        val country_id: String,
        val state_id: String,
        val city: String,
        val zip_code: String,
        val address: String,
        val seller_url: String,
        val facebook_url: String,
        val twitter_url: String,
        val instagram_url: String,
        val linkedin_url: String,
        val business_type: String
    )
}