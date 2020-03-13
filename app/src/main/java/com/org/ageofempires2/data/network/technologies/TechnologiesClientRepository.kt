package com.org.ageofempires2.data.network.technologies

import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase
import io.reactivex.Completable
import io.reactivex.Single

interface TechnologiesClientRepository {
    fun getAoe(): Single<AoeMainBase>

    fun getAeoFromDb(): Single<AoeMainBase>

    fun addAoeFromDb(data: AoeMainBase): Completable
}