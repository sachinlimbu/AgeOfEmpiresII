package com.org.ageofempires2.di.component

import com.org.ageofempires2.di.module.Aoe2ViewModel
import com.org.ageofempires2.di.scope.ActivityScope
import com.org.ageofempires2.view.MainActivity
import dagger.Component

@Component(modules = [Aoe2ViewModel::class],dependencies = [AppComponent::class])
@ActivityScope
interface SearchComponent {
    fun inject(mainActivity: MainActivity)
}