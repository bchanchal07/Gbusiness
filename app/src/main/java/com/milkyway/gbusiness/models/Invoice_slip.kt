package com.milkyway.gbusiness.models

data class Invoice_slip(
    val invoice_no: String,
    val domain_name: String,
    val description: String,
    val price: Double,
    val total: Double
)