package com.milkyway.gbusiness.models

import java.io.Serializable

class StepOneItemListsModel(
    val success: Boolean,
    var status: Boolean,
    var message: String,
    val data: List<BusinessItemsList> = ArrayList(),
) {
    data class BusinessItemsList(
        val id: String,
        val user_id: String,
        val business_id: String,
        val name: String,
        val pmethod_image: String,
        val email: String,
        val bank_details: String,
        val payment_url: String? = null,
        val created_at: String,
        val updated_at: String,
        val gallery_image: String,
    ) : Serializable
}
