package com.milkyway.gbusiness.models

data class ForgetPasswordDataClass(
    val `data`: String,
    val otp: Int,
    val success: Boolean,
    val user_id: Int,
    val question: String,
    val security_question: String
)