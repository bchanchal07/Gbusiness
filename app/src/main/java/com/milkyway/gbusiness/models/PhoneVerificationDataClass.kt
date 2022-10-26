package com.milkyway.gbusiness.models

data class PhoneVerificationDataClass(
    val `data`: String,
    val success: Boolean,
    val user_id: String,
    val error: String
)