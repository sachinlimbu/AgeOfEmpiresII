package com.org.ageofempires2.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.org.ageofempires2.data.network.RepoClientRepository
import javax.inject.Inject

class CivilizationsViewModelFactory @Inject constructor(
    private val repository: RepoClientRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CivilizationsViewModel(
            repository) as T
    }
}