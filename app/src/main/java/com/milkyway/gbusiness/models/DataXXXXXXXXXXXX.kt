package com.milkyway.gbusiness.models

data class DataXXXXXXXXXXXX(
    val que_amount: String,
    val que_category: String,
    val que_id: Int,
) {
    override fun toString(): String {
        return que_amount
    }
}