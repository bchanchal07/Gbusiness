package com.milkyway.gbusiness.models


import com.google.gson.annotations.SerializedName

data class CategoryDataDetailsClass(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("msg")
    val msg: String
) {
    data class Data(
        @SerializedName("category_name")
        val categoryName: String,
        @SerializedName("next")
        val next: String,
        @SerializedName("page")
        val page: Int,
        @SerializedName("page_first_result")
        val pageFirstResult: Int,
        @SerializedName("prev")
        val prev: String,
        @SerializedName("results_per_page")
        val resultsPerPage: Int,
        @SerializedName("rows")
        val rows: Int,
        @SerializedName("template_details")
        val templateDetails: List<TemplateDetail>,
        @SerializedName("total_row")
        val totalRow: Int
    ) {
        data class TemplateDetail(
            @SerializedName("avatar")
            val avatar: String,
            @SerializedName("business_about_us")
            val businessAboutUs: String,
            @SerializedName("business_email")
            val businessEmail: String,
            @SerializedName("business_logo")
            val businessLogo: Any,
            @SerializedName("business_web_url")
            val businessWebUrl: String,
            @SerializedName("buy_domain_id")
            val buyDomainId: Int,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("domain")
            val domain: String,
            @SerializedName("domain_name")
            val domainName: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("mime_type")
            val mimeType: Any,
            @SerializedName("name")
            val name: String,
            @SerializedName("path")
            val path: String,
            @SerializedName("profession")
            val profession: String,
            @SerializedName("project_id")
            val projectId: String,
            @SerializedName("project_path")
            val projectPath: Any,
            @SerializedName("publish")
            val publish: String,
            @SerializedName("size")
            val size: Any,
            @SerializedName("ssl_status")
            val sslStatus: String,
            @SerializedName("status")
            val status: String,
            @SerializedName("t_name")
            val tName: String,
            @SerializedName("temp_category_id")
            val tempCategoryId: Int,
            @SerializedName("temp_sub_category_id")
            val tempSubCategoryId: Any,
            @SerializedName("thumbnail")
            val thumbnail: String,
            @SerializedName("title")
            val title: String,
            @SerializedName("total_size")
            val totalSize: Any,
            @SerializedName("updated_at")
            val updatedAt: String,

            @SerializedName("user_id")
            val userId: Int,
            @SerializedName("user_name")
            val userName: String
        )
    }
}