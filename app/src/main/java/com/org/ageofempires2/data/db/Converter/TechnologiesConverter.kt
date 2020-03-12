package com.org.ageofempires2.data.db.Converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.org.ageofempires2.data.model.technologies.Technologies

class TechnologiesConverter {
    val gson= Gson()

    @TypeConverter
    fun fromCivilizationList(value: List<Technologies>): String {
        val type = object : TypeToken<List<Technologies>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toCivilizationList(value: String):List<Technologies> {
        val gson = Gson()
        val type = object : TypeToken<List<Technologies>>() {}.type
        return gson.fromJson(value, type)
    }

}