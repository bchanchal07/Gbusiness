package com.milkyway.gbusiness.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SignupDataErrorResponse(

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("error")
	val error: Error
) : Parcelable

@Parcelize
data class Error(

	@field:SerializedName("phone")
	val phone: List<String>,

	@field:SerializedName("email")
	val email: List<String>
) : Parcelable
