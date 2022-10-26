package com.milkyway.gbusiness.models

import com.google.gson.annotations.SerializedName

data class CartItemDataClass(
    @SerializedName("domain_name")
    val domain_name: String,
    @SerializedName("domain_price")
    val domain_price: String,
    @SerializedName("domain_order_id")
    val domain_order_id: String,
)
