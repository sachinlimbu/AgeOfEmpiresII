package com.org.ageofempires2.data.db.Converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.org.ageofempires2.data.model.unit.Units

class UnitsConverter {
    val gson= Gson()

    @TypeConverter
    fun fromCivilizationList(value: List<Units>): String {
        val type = object : TypeToken<List<Units>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toCivilizationList(value: String):List<Units> {
        val gson = Gson()
        val type = object : TypeToken<List<Units>>() {}.type
        return gson.fromJson(value, type)
    }

}