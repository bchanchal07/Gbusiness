package com.milkyway.gbusiness.models

import com.google.gson.annotations.SerializedName

data class SearchSubdomainSuccess(

	@field:SerializedName("domain_n")
	val domainN: String? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("Sub_domain_name")
	val subDomainName: String? = null
)
