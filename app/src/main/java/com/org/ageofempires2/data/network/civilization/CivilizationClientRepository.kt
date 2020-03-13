package com.org.ageofempires2.data.network.civilization

import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase
import com.org.ageofempires2.data.model.civilization.Civilizations
import io.reactivex.Completable
import io.reactivex.Single

interface CivilizationClientRepository {

    fun getAoe(): Single<AoeMainBase>

    fun getAeoFromDb():Single<AoeMainBase>

    fun addAoeFromDb(data:AoeMainBase):Completable
}