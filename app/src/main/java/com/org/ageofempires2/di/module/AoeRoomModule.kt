package com.org.ageofempires2.di.module

import android.content.Context
import com.org.ageofempires2.data.db.AoeDatabase
import com.org.ageofempires2.data.db.AoeDatabase2
import com.org.ageofempires2.data.db.AoeDatabase3
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AoeRoomModule (private val context: Context){
    @Provides
    @Singleton
    fun provideDatabase(): AoeDatabase{
        return AoeDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideDatabase2(): AoeDatabase2{
        return AoeDatabase2.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideDatabase3(): AoeDatabase3{
        return AoeDatabase3.getInstance(context)
    }




}