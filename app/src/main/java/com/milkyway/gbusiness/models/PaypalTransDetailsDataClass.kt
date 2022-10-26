package com.milkyway.gbusiness.models

data class PaypalTransDetailsDataClass(
    val cart: String,
    val create_time: String,
    val id: String,
    val intent: String,
    val links: List<LinkX>,
    val payer: Payer,
    val state: String,
    val transactions: List<Transaction>,
    val update_time: String
)