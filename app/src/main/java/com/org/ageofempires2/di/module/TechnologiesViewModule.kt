package com.org.ageofempires2.di.module

import androidx.lifecycle.ViewModelProvider
import com.org.ageofempires2.data.db.AoeDatabase3
import com.org.ageofempires2.data.network.RepoClient
import com.org.ageofempires2.data.network.technologies.TechnologiesClientImplementation
import com.org.ageofempires2.data.network.technologies.TechnologiesClientRepository
import com.org.ageofempires2.di.scope.ActivityScope
import com.org.ageofempires2.fragment.TechnologiesFragment
import com.org.ageofempires2.viewModel.technologies.TechnologiesViewModel
import com.org.ageofempires2.viewModel.technologies.TechnologiesViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class TechnologiesViewModule(private val fragment: TechnologiesFragment){

    @Provides
    @ActivityScope
    fun provideViewModelFactory(repository: TechnologiesClientRepository): TechnologiesViewModelFactory {
        return TechnologiesViewModelFactory(
            repository
        )
    }
    @Provides
    @ActivityScope
    fun provideViewModel(factory: TechnologiesViewModelFactory): TechnologiesViewModel {
        return ViewModelProvider(fragment,factory).get(TechnologiesViewModel::class.java)
    }
    @Provides
    @ActivityScope
    fun provideCivilRepository(client: RepoClient, aoeDatabase: AoeDatabase3): TechnologiesClientRepository {
        return TechnologiesClientImplementation(
            client,
            aoeDatabase
        )
    }
}