package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class CheckoutRequest(
    @SerializedName("cart")
    val cart: List<Cart>,

    ) {

    data class Cart(
        @SerializedName("domain")
        val domain: String, // kam.ac.in
        @SerializedName("whmcs_client_id")
        val whmcsClientId: Int, // 23
        @SerializedName("year")
        val year: Int, // 1
    )
}