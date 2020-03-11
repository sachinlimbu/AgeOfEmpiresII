package com.org.ageofempires2.data.model.civilization

import com.google.gson.annotations.SerializedName

data class Civilizations (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("expansion") val expansion : String,
	@SerializedName("army_type") val army_type : String,
	@SerializedName("unique_unit") val unique_unit : List<String>,
	@SerializedName("unique_tech") val unique_tech : List<String>,
	@SerializedName("team_bonus") val team_bonus : String,
	@SerializedName("civilization_bonus") val civilization_bonus : List<String>
)