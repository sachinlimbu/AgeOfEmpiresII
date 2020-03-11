package com.org.ageofempires2.data.model.unit

import com.google.gson.annotations.SerializedName

data class Cost (

	@SerializedName("Wood") val wood : Int,
	@SerializedName("Gold") val gold : Int
)