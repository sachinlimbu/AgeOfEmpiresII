package com.org.ageofempires2.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.org.ageofempires2.data.db.Converter.CivilizationsConverter
import com.org.ageofempires2.data.db.Converter.StructuresConverter
import com.org.ageofempires2.data.db.Converter.TechnologiesConverter
import com.org.ageofempires2.data.db.Converter.UnitsConverter
import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase

@Database(entities = [AoeMainBase::class],version = 1,exportSchema = false)
@TypeConverters(
    CivilizationsConverter::class,
    StructuresConverter::class,
    TechnologiesConverter::class,
    UnitsConverter::class)
abstract class AoeDatabase2 :RoomDatabase(){

    abstract fun getAoeDao():AoeDao

    companion object{
        @Volatile
        private var INSTANCE: AoeDatabase2? = null

        fun getInstance(context: Context): AoeDatabase2 {
            synchronized(this){
                var instance =
                    INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AoeDatabase2::class.java,
                    "AOEMAIN_db2"
                    ).fallbackToDestructiveMigration().build()
                }
                return instance
            }
        }
    }
}