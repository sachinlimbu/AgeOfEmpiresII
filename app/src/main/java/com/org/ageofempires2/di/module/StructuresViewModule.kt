package com.org.ageofempires2.di.module

import androidx.lifecycle.ViewModelProvider
import com.org.ageofempires2.data.db.AoeDatabase
import com.org.ageofempires2.data.db.AoeDatabase2
import com.org.ageofempires2.data.network.RepoClient
import com.org.ageofempires2.data.network.Stuctures.StructuresClientRepository
import com.org.ageofempires2.data.network.Stuctures.StructuresImplemantation
import com.org.ageofempires2.di.scope.ActivityScope
import com.org.ageofempires2.fragment.StructuresFragment
import com.org.ageofempires2.viewModel.structures.StructuresViewModel
import com.org.ageofempires2.viewModel.structures.StructuresViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class StructuresViewModule(private val structuresFragment: StructuresFragment){

    @Provides
    @ActivityScope
    fun provideViewModelFactory(repository: StructuresClientRepository): StructuresViewModelFactory {
        return StructuresViewModelFactory(
            repository
        )
    }
    @Provides
    @ActivityScope
    fun provideViewModel(factory: StructuresViewModelFactory): StructuresViewModel {
        return ViewModelProvider(structuresFragment,factory).get(StructuresViewModel::class.java)
    }
    @Provides
    @ActivityScope
    fun provideCivilRepository(client: RepoClient, aoeDatabase: AoeDatabase2): StructuresClientRepository {
        return StructuresImplemantation(
            client,
            aoeDatabase
        )
    }
}