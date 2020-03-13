package com.org.ageofempires2.di.component

import com.org.ageofempires2.di.module.CivilizationViewModule
import com.org.ageofempires2.di.scope.ActivityScope
import com.org.ageofempires2.fragment.CivilizationsFragment
import dagger.Component

@Component(modules = [CivilizationViewModule::class], dependencies = [AppComponent::class])
@ActivityScope
interface CivilizationComponent {
    fun inject(civilizationsFragment: CivilizationsFragment)
}