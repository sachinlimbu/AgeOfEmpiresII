package com.org.ageofempires2.viewModel.civilization

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.org.ageofempires2.data.network.civilization.CivilizationClientRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class CivilizationsViewModelFactory @Inject constructor(
    private val repository: CivilizationClientRepository
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CivilizationsViewModel(
            repository
        ) as T
    }
}