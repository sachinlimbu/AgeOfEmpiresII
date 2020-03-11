package com.org.ageofempires2.data.model.aoe2Main

import com.google.gson.annotations.SerializedName
import com.org.ageofempires2.data.model.civilization.Civilizations
import com.org.ageofempires2.data.model.structures.Structures
import com.org.ageofempires2.data.model.technologies.Technologies
import com.org.ageofempires2.data.model.unit.Units

data class Aoe2MainBase (
	@SerializedName("civilizations") val civilizations : List<Civilizations>,
	@SerializedName("structures") val structures : List<Structures>,
	@SerializedName("technologies") val technologies : List<Technologies>,
	@SerializedName("units") val units : List<Units>
)