package com.org.ageofempires2.data.network

import com.org.ageofempires2.END_POINT_CIVIL
import com.org.ageofempires2.END_POINT_STRUCT
import com.org.ageofempires2.END_POINT_TECH
import com.org.ageofempires2.END_POINT_UNITS
import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase
import io.reactivex.Single
import retrofit2.http.GET

interface RepoClient {
    @GET(END_POINT_CIVIL)
    fun getAOE2Civilizations(): Single<AoeMainBase>

    @GET(END_POINT_STRUCT)
    fun getAOE2Stuctures():Single<AoeMainBase>

    @GET(END_POINT_TECH)
    fun getAOE2Technologies():Single<AoeMainBase>

    @GET(END_POINT_UNITS)
    fun getAOE2Unit():Single<AoeMainBase>


}