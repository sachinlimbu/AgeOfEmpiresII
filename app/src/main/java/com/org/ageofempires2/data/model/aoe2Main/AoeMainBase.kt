package com.org.ageofempires2.data.model.aoe2Main

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.org.ageofempires2.data.db.Converter.CivilizationsConverter
import com.org.ageofempires2.data.db.Converter.StructuresConverter
import com.org.ageofempires2.data.db.Converter.TechnologiesConverter
import com.org.ageofempires2.data.db.Converter.UnitsConverter
import com.org.ageofempires2.data.model.civilization.Civilizations
import com.org.ageofempires2.data.model.structures.Structures
import com.org.ageofempires2.data.model.technologies.Technologies
import com.org.ageofempires2.data.model.unit.Units

@Entity(tableName = "aoe_main_base")
data class AoeMainBase (
	@PrimaryKey @NonNull
	val name: String,

	@SerializedName("civilizations")
	@TypeConverters(CivilizationsConverter::class)
	val civilizations : List<Civilizations>,
	@TypeConverters(StructuresConverter::class)
	@SerializedName("structures") val structures : List<Structures>,
	@TypeConverters(TechnologiesConverter::class)
	@SerializedName("technologies") val technologies : List<Technologies>,
	@TypeConverters(UnitsConverter::class)
	@SerializedName("units") val units : List<Units>

)