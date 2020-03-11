package com.org.ageofempires2.data.network

import com.org.ageofempires2.END_POINT
import com.org.ageofempires2.data.model.aoe2Main.Aoe2MainBase
import io.reactivex.Single
import retrofit2.http.GET

interface RepoClient {
    @GET(END_POINT)
    fun getAOE2Civilizations(): Single<Aoe2MainBase>
}