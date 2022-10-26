package com.milkyway.gbusiness.models
import com.google.gson.annotations.SerializedName

data class BusinessPaymentDataClass(
    val `data`: List<Data>,
    val message: String, // Data fetched Successfully!
    val success: Boolean // true
) {
    data class Data(
        @SerializedName("bank_details")
        val bankDetails: String, // null
        @SerializedName("business_id")
        val businessId: String, // 3
        @SerializedName("created_at")
        val createdAt: String, // 2022-04-29 05:28:19
        val email: String, // ifo@milkywayinfotech.in
        val id: Int, // 1
        val name: String, // Paytm
        @SerializedName("payment_url")
        val paymentUrl: String, // null
        @SerializedName("pmethod_image")
        val pmethodImage: String, // paytm.jpg
        @SerializedName("updated_at")
        val updatedAt: String, // 2022-04-29 05:28:19
        @SerializedName("user_id")
        val userId: String // 3
    )
}