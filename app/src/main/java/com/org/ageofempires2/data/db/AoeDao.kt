package com.org.ageofempires2.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase
import com.org.ageofempires2.data.model.civilization.Civilizations
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface AoeDao {
    @Query("SELECT * FROM aoe_main_base")
    fun getAllAoeMainBase():Single<AoeMainBase>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAoeDatabase(aoeMainBase: AoeMainBase):Completable
}