package com.milkyway.gbusiness.models


data class BusinessServiceModelClass(
    val `data`: List<Data>,
    val message: String, // Data fetched Successfully!
    val success: Boolean, // true
) {
    data class Data(
        val id: Int, // 1
        val name: String, // Abbey
    )
}