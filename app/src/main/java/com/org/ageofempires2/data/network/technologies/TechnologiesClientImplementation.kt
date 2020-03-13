package com.org.ageofempires2.data.network.technologies

import android.util.Log
import com.org.ageofempires2.REPOSITORY_CHECK
import com.org.ageofempires2.REPOSITORY_CHECK_COMPELETED
import com.org.ageofempires2.REPOSITORY_CHECK_NOT_COMPELETED
import com.org.ageofempires2.data.db.AoeDatabase
import com.org.ageofempires2.data.db.AoeDatabase3
import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase
import com.org.ageofempires2.data.network.RepoClient
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TechnologiesClientImplementation @Inject constructor(
    private val repoClient: RepoClient,
    private val localDataSource: AoeDatabase3
):TechnologiesClientRepository{
    override fun getAoe(): Single<AoeMainBase> {
        return repoClient.getAOE2Technologies()
            .doOnSuccess{
                    aoe -> addAoeFromDb(aoe).subscribe({
                Log.i(REPOSITORY_CHECK,REPOSITORY_CHECK_COMPELETED)
            },{
                Log.i(REPOSITORY_CHECK,REPOSITORY_CHECK_NOT_COMPELETED)
            })
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getAeoFromDb(): Single<AoeMainBase> {
        return localDataSource.getAoeDao().getAllAoeMainBase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun addAoeFromDb(data: AoeMainBase): Completable {
        return localDataSource.getAoeDao().insertAoeDatabase(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}