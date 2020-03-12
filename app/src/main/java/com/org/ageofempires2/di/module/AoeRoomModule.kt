package com.org.ageofempires2.di.module

import android.content.Context
import com.org.ageofempires2.data.db.AoeDatabase
import dagger.Module
import dagger.Provides

@Module
class AoeRoomModule (private val context: Context){
    @Provides
    fun provideDatabase(): AoeDatabase{
        return AoeDatabase.getInstance(context)
    }
}