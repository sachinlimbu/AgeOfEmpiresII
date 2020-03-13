package com.org.ageofempires2.di.component

import com.org.ageofempires2.MyApp
import com.org.ageofempires2.data.db.AoeDatabase
import com.org.ageofempires2.data.db.AoeDatabase2
import com.org.ageofempires2.data.db.AoeDatabase3
import com.org.ageofempires2.data.network.RepoClient
import com.org.ageofempires2.di.module.AoeRoomModule
import com.org.ageofempires2.di.module.NetworkModule
import com.org.ageofempires2.fragment.StructuresFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, AoeRoomModule::class])
@Singleton
interface AppComponent {
    fun inject(myApp: MyApp)
    fun client():RepoClient
    fun database(): AoeDatabase
    fun database2(): AoeDatabase2
    fun database3(): AoeDatabase3


}