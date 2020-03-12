package com.org.ageofempires2.di.component

import com.org.ageofempires2.di.module.Aoe2ViewModule
import com.org.ageofempires2.di.scope.ActivityScope
import com.org.ageofempires2.view.MainActivity
import dagger.Component

@Component(modules = [Aoe2ViewModule::class],dependencies = [AppComponent::class])
@ActivityScope
interface SearchComponent {
    fun inject(mainActivity: MainActivity)
}