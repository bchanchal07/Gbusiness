package com.milkyway.gbusiness.models

data class Card(
    val emi: Boolean,
    val entity: String,
    val id: String,
    val international: Boolean,
    val issuer: Any,
    val last4: String,
    val name: String,
    val network: String,
    val type: String
)