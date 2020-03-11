package com.org.ageofempires2

import android.app.Application
import com.org.ageofempires2.di.component.AppComponent
import com.org.ageofempires2.di.component.DaggerAppComponent
import com.org.ageofempires2.di.module.NetworkModule

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    fun component():AppComponent{
        return DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .build()
    }
}