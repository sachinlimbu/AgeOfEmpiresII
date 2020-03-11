package com.org.ageofempires2.data.model.structures

import com.google.gson.annotations.SerializedName

data class Structures (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("expansion") val expansion : String,
	@SerializedName("age") val age : String,
	@SerializedName("cost") val cost : Cost,
	@SerializedName("build_time") val build_time : Int,
	@SerializedName("hit_points") val hit_points : Int,
	@SerializedName("line_of_sight") val line_of_sight : Int,
	@SerializedName("armor") val armor : String,
	@SerializedName("special") val special : List<String>
)