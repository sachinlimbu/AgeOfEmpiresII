package com.org.ageofempires2.data.network

import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase
import io.reactivex.Single

interface RepoClientRepository {

    fun getAoe2(): Single<AoeMainBase>

}