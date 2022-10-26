package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class RazorTransCaptureResponse(
    @SerializedName("acquirer_data")
    val acquirerData: AcquirerData,
    val amount: Int, // 112500
    @SerializedName("amount_refunded")
    val amountRefunded: Int, // 0
    val bank: Any, // null
    val captured: Boolean, // true
    val card: Card,
    @SerializedName("card_id")
    val cardId: String, // card_IwdMmBf3AUxgbz
    val contact: String, // +919540381085
    @SerializedName("created_at")
    val createdAt: Int, // 1645004320
    val currency: String, // INR
    val description: String, // Get a Professional Logo
    val email: String, // vkpal.its@gmail.com
    val entity: String, // payment
    @SerializedName("error_code")
    val errorCode: Any, // null
    @SerializedName("error_description")
    val errorDescription: Any, // null
    @SerializedName("error_reason")
    val errorReason: Any, // null
    @SerializedName("error_source")
    val errorSource: Any, // null
    @SerializedName("error_step")
    val errorStep: Any, // null
    val fee: Int, // 2250
    val id: String, // pay_IwdMm8JfIKpYqn
    val international: Boolean, // false
    @SerializedName("invoice_id")
    val invoiceId: Any, // null
    val method: String, // card
    val notes: Notes,
    @SerializedName("order_id")
    val orderId: Any, // null
    @SerializedName("refund_status")
    val refundStatus: Any, // null
    val status: String, // captured
    val tax: Int, // 0
    val vpa: Any, // null
    val wallet: Any // null
) {
    data class AcquirerData(
        @SerializedName("auth_code")
        val authCode: String // 548439
    )

    data class Card(
        val emi: Boolean, // false
        val entity: String, // card
        val id: String, // card_IwdMmBf3AUxgbz
        val international: Boolean, // false
        val issuer: Any, // null
        val last4: String, // 1111
        val name: String, // Test Card
        val network: String, // Visa
        @SerializedName("sub_type")
        val subType: String, // consumer
        @SerializedName("token_iin")
        val tokenIin: Any, // null
        val type: String // debit
    )

    data class Notes(
        val address: String, // H 146 147 Sector 63, Noida - 201301
        @SerializedName("merchant_order_id")
        val merchantOrderId: String // 95
    )
}