package com.milkyway.gbusiness.models

data class Domain(
    val buy_domain_id: Int,
    val created_at: String,
    val id: Int,
    val name: String,
    val path: String,
    val status: String,
    val total_size: Any,
    val updated_at: String,
    val user_id: Int
)