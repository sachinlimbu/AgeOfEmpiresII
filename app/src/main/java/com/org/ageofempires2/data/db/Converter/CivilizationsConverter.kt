package com.org.ageofempires2.data.db.Converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase
import com.org.ageofempires2.data.model.civilization.Civilizations

class CivilizationsConverter {
    val gson= Gson()

    @TypeConverter
    fun fromCivilizationList(value: List<Civilizations>): String {
        val type = object : TypeToken<List<Civilizations>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toCivilizationList(value: String):List<Civilizations> {
        val gson = Gson()
        val type = object : TypeToken<List<Civilizations>>() {}.type
        return gson.fromJson(value, type)
    }

}