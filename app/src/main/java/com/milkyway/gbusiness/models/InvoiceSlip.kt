package com.milkyway.gbusiness.models

data class InvoiceSlip(
    val description: String,
    val domain_name: String,
    val invoice_no: Int,
    val price: String,
    val total: String
)