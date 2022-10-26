package com.milkyway.gbusiness.models

data class PayPalAccessToken(
    val access_token: String,
    val app_id: String,
    val expires_in: Int,
    val nonce: String,
    val scope: String,
    val token_type: String
)