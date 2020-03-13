package com.org.ageofempires2.di.component

import com.org.ageofempires2.di.module.CivilizationViewModule
import com.org.ageofempires2.di.module.StructuresViewModule
import com.org.ageofempires2.di.scope.ActivityScope
import com.org.ageofempires2.fragment.CivilizationsFragment
import com.org.ageofempires2.fragment.StructuresFragment
import dagger.Component

@Component(modules = [StructuresViewModule::class], dependencies = [AppComponent::class])
@ActivityScope
interface StructuresComponent {
    fun inject(structuresFragment: StructuresFragment)
}