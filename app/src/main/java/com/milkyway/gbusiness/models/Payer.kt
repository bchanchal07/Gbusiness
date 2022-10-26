package com.milkyway.gbusiness.models

data class Payer(
    val payer_info: PayerInfo,
    val payment_method: String,
    val status: String
)