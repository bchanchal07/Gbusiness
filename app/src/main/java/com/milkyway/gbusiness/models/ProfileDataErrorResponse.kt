package com.milkyway.gbusiness.models


data class ProfileDataErrorResponse(
    val `data`: Any, // null
    val message: String, // User not exits in database or somthing went wrong
    val success: Boolean // false
)