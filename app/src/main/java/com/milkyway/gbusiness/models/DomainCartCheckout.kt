package com.milkyway.gbusiness.models


data class DomainCartCheckout(
    val addonids: String,
    val domainids: String, // 42,43
    val invoiceid: Int, // 35
    val orderid: Int, // 35
    val productids: String,
    val result: String, // success
    val serviceids: String
)