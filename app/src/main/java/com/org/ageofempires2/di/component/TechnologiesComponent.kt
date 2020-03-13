package com.org.ageofempires2.di.component

import com.org.ageofempires2.di.module.TechnologiesViewModule
import com.org.ageofempires2.di.scope.ActivityScope
import com.org.ageofempires2.fragment.TechnologiesFragment
import dagger.Component

@Component(modules = [TechnologiesViewModule::class], dependencies = [AppComponent::class])
@ActivityScope
interface TechnologiesComponent {
    fun inject(technologiesFragment: TechnologiesFragment)
}