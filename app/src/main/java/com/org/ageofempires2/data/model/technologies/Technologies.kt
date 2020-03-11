package com.org.ageofempires2.data.model.technologies

import com.google.gson.annotations.SerializedName


data class Technologies (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("description") val description : String,
	@SerializedName("expansion") val expansion : String,
	@SerializedName("age") val age : String,
	@SerializedName("develops_in") val develops_in : String,
	@SerializedName("cost") val cost : Cost,
	@SerializedName("build_time") val build_time : Int,
	@SerializedName("applies_to") val applies_to : List<String>
)