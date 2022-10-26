package com.milkyway.gbusiness.models

data class PayerInfo(
    val country_code: String,
    val email: String,
    val first_name: String,
    val last_name: String,
    val payer_id: String,
    val phone: String,
    val shipping_address: ShippingAddress
)