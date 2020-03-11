package com.org.ageofempires2.data.model.technologies

import com.google.gson.annotations.SerializedName

data class Cost (

	@SerializedName("Food") val food : Int,
	@SerializedName("Gold") val gold : Int
)