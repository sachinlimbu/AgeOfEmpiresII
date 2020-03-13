package com.org.ageofempires2.di.module

import androidx.lifecycle.ViewModelProvider
import com.org.ageofempires2.data.db.AoeDatabase
import com.org.ageofempires2.data.network.RepoClient
import com.org.ageofempires2.data.network.civilization.CivilizationClientRepository
import com.org.ageofempires2.data.network.civilization.CivilizationImplemantation
import com.org.ageofempires2.di.scope.ActivityScope
import com.org.ageofempires2.fragment.CivilizationsFragment
import com.org.ageofempires2.viewModel.civilization.CivilizationsViewModel
import com.org.ageofempires2.viewModel.civilization.CivilizationsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CivilizationViewModule(private val civilizationsFragment: CivilizationsFragment ){
    @Provides
    @ActivityScope
    fun provideViewModelFactory(repository: CivilizationClientRepository): CivilizationsViewModelFactory {
        return CivilizationsViewModelFactory(
            repository
        )
    }
    @Provides
    @ActivityScope
    fun provideViewModel(factory: CivilizationsViewModelFactory): CivilizationsViewModel {
        return ViewModelProvider(civilizationsFragment,factory).get(CivilizationsViewModel::class.java)
    }
    @Provides
    @ActivityScope
    fun provideCivilRepository(client:RepoClient, aoeDatabase: AoeDatabase): CivilizationClientRepository {
        return CivilizationImplemantation(
            client,
            aoeDatabase
        )
    }
}