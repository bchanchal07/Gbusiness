package com.milkyway.gbusiness.models

class BusinessListStepOneModel(
    val success: Boolean,
    val message: String,
    val data: Data,
    val error: Error,
) {
    data class Data(
        val pmethod_image: String,
        val user_id: String,
        val name: String,
        val email: String,
        val payment_url: String,
        val bank_details: String,
        val business_id: String,
    )

    data class Error (
        val email: List<String>
    )
}
