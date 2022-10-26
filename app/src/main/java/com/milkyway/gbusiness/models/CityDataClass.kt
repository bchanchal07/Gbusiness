package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class CityDataClass(
    @SerializedName("cities")
    val cities: List<City>
) {
    data class City(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
    )
}