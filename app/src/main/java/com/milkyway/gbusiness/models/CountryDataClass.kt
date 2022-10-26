package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class CountryDataClass(
    @SerializedName("countries")
    val countries: List<Country>
) {
    data class Country(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
    )
}