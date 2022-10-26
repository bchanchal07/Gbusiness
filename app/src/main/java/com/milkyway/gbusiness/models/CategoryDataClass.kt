package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class CategoryDataClass(
    val code: Int, // 200
    val `data`: List<Data>,
    val msg: String // Data feteched Successfully
) {
    data class Data(
        @SerializedName("cat_content")
        val catContent: String, // The “Legal and Financial Services” is a type of business service that offer various benefits to the user in terms of finance and legal terms. It helps the users to prepare their account files, invoices, and inventory through our GBusiness legal and financial services. Businessmen or new industrialist can easily manage their financial tasks using the business of Legal and Financial Services that can be listed using the GBusiness web portal. 
        @SerializedName("cat_url")
        val catUrl: String, // legal-and-financial-services
        @SerializedName("created_at")
        val createdAt: String, // 2021-11-23T22:12:28.000000Z
        val id: Int, // 1
        val image: Any, // null
        val name: String, // Legal and Financial Services
        @SerializedName("updated_at")
        val updatedAt: String // 2022-03-24T04:08:01.000000Z
    )
}