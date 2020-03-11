package com.org.ageofempires2.di.component

import com.org.ageofempires2.MyApp
import com.org.ageofempires2.data.network.RepoClient
import com.org.ageofempires2.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {
    fun inject(myApp: MyApp)
    fun client():RepoClient

}