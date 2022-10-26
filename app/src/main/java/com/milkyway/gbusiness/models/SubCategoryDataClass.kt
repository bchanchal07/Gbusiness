package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class SubCategoryDataClass(
    @SerializedName("subcategory")
    val subcategory: List<Subcategory>
) {
    data class Subcategory(
        @SerializedName("id")
        val id: Int,
        @SerializedName("image")
        val image: String,
        @SerializedName("name")
        val name: String
    )
}