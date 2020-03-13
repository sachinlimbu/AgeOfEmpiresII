package com.org.ageofempires2.viewModel.structures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.org.ageofempires2.data.network.Stuctures.StructuresClientRepository
import com.org.ageofempires2.data.network.civilization.CivilizationClientRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class StructuresViewModelFactory @Inject constructor(
    private val repository: StructuresClientRepository
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StructuresViewModel(
            repository
        ) as T
    }
}