package com.org.ageofempires2.di.module

import androidx.lifecycle.ViewModelProvider
import com.org.ageofempires2.view.MainActivity
import com.org.ageofempires2.data.network.RepoClient
import com.org.ageofempires2.data.network.RepoClientRepository
import com.org.ageofempires2.data.network.RepoImpl
import com.org.ageofempires2.di.scope.ActivityScope
import com.org.ageofempires2.viewModel.CivilizationsViewModel
import com.org.ageofempires2.viewModel.CivilizationsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class Aoe2ViewModel(private val mainActivity: MainActivity){


    @Provides
    @ActivityScope
    fun provideViewModelFactory(repository: RepoClientRepository):CivilizationsViewModelFactory{
        return CivilizationsViewModelFactory(repository)
    }

    @Provides
    @ActivityScope
    fun provideViewModel(factory:CivilizationsViewModelFactory):CivilizationsViewModel{
        return ViewModelProvider(mainActivity,factory).get(CivilizationsViewModel::class.java)
    }



    @Provides
    @ActivityScope
    fun provideRepository(client:RepoClient):RepoClientRepository{
        return RepoImpl(client)
    }

}