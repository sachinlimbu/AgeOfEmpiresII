package com.org.ageofempires2.data.network

import com.org.ageofempires2.data.model.aoe2Main.Aoe2MainBase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepoImpl(private val repoClient: RepoClient):RepoClientRepository {
    override fun getAoe2(): Single<Aoe2MainBase> {
        return repoClient.getAOE2Civilizations()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}