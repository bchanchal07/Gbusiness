package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class StateDataClass(
    @SerializedName("states")
    val states: List<State>
) {
    data class State(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
    )
}