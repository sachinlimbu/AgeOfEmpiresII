package com.org.ageofempires2.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase

@Dao
interface AoeDao {
    @Query("SELECT * FROM aoe_main_base")
    fun getAllAoeMainBase():LiveData<AoeMainBase>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(aoeMainBase: AoeMainBase)
}