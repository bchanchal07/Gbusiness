package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BusinessListingResponse(
    val data: List<Data> = ArrayList(),
    val message: String,
    val success: Boolean
) {
    data class Data(
        val business_about_us: String,
        val business_email: String,
        val business_logo: String,
        val business_name: String,
        val business_type: String,
        val business_web_url: String,
        val category_id: Int,
        val catname: String,
        val created_at: String,
        val id: Int,
        val status: Int,
        val sub_category_id: Int,
        val subcatname: String,
        val updated_at: String,
        val user_id: Int,
        val sub_domain: String,
        val url_slug: String,
        val business_phone: String,
        val country_id: Long,
        val state_id: Long,
        val city: String,
        val zip_code: String,
        val address: String,
        val business_services: Any? = null,
        val business_services_other: Any? = null,
        val facebook_url: String? = null,
        val twitter_url: String? = null,
        val instagram_url: String? = null,
        val linkedin_url: String? = null,
        val seller_url: String? = null,
        val establish_date: String? = null,
        val sunday: Any? = null,
        val sunday_start_time: Any? = null,
        val sunday_end_time: Any? = null,
        val monday: Any? = null,
        val monday_start_time: Any? = null,
        val monday_end_time: Any? = null,
        val tuesday: Any? = null,
        val tuesday_start_time: Any? = null,
        val tuesday_end_time: Any? = null,
        val wednesday: Any? = null,
        val wednesday_start_time: Any? = null,
        val wednesday_end_time: Any? = null,
        val thirsday: Any? = null,
        val thirsday_start_time: Any? = null,
        val thirsday_end_time: Any? = null,
        val friday: Any? = null,
        val friday_start_time: Any? = null,
        val friday_end_time: Any? = null,
        val saturday: Any? = null,
        val saturday_start_time: Any? = null,
        val saturday_end_time: Any? = null,
        val sponsor: Long,

    ):Serializable
}