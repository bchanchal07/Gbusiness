package com.milkyway.gbusiness.models

data class CartDataItemClass(
    val `data`: ArrayList<Data>,
) {
    data class Data(
        val domainName: String,
        val domainPrice: String,
        val domainOrderId: String,
    )
}