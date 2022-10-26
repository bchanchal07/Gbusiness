package com.milkyway.gbusiness.models


data class GalleryModelData(
    val `data`: List<Data>,
    val message: String,
    val success: Boolean,
) {
    data class Data(
        val id: String?,
        val name: String?,
        val image: String?,
    )
}