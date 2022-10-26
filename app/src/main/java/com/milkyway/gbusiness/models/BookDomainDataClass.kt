package com.milkyway.gbusiness.models

data class BookDomainDataClass
    (
    val domain_details: DomainDetails,
    val domain_name: String,
    val cart_id: String,
    val domain_n: String,
    val success: Boolean,
    val error: String
)