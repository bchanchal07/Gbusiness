package com.milkyway.gbusiness.models

import com.google.gson.annotations.SerializedName

data class SearchSubdomainFalse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("success")
	val success: Boolean? = null
)
