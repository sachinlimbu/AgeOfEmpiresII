package com.org.ageofempires2.data.db.Converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.org.ageofempires2.data.model.structures.Structures

class StructuresConverter {
    val gson= Gson()

    @TypeConverter
    fun fromCivilizationList(value: List<Structures>): String {
        val type = object : TypeToken<List<Structures>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toCivilizationList(value: String):List<Structures> {
        val gson = Gson()
        val type = object : TypeToken<List<Structures>>() {}.type
        return gson.fromJson(value, type)
    }

}