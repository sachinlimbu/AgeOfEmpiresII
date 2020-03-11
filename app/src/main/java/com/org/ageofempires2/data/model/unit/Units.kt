package com.org.ageofempires2.data.model.unit

import com.google.gson.annotations.SerializedName

data class Units (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("description") val description : String,
	@SerializedName("expansion") val expansion : String,
	@SerializedName("age") val age : String,
	@SerializedName("created_in") val created_in : String,
	@SerializedName("cost") val cost : Cost,
	@SerializedName("build_time") val build_time : Int,
	@SerializedName("reload_time") val reload_time : Int,
	@SerializedName("attack_delay") val attack_delay : Double,
	@SerializedName("movement_rate") val movement_rate : Double,
	@SerializedName("line_of_sight") val line_of_sight : Int,
	@SerializedName("hit_points") val hit_points : Int,
	@SerializedName("range") val range : Int,
	@SerializedName("attack") val attack : Int,
	@SerializedName("armor") val armor : String,
	@SerializedName("accuracy") val accuracy : String
)