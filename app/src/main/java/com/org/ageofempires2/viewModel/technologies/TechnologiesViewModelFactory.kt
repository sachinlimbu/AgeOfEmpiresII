package com.org.ageofempires2.viewModel.technologies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.org.ageofempires2.data.network.technologies.TechnologiesClientRepository
import javax.inject.Inject

class TechnologiesViewModelFactory @Inject constructor(
    private val technologiesClientRepository: TechnologiesClientRepository
):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TechnologiesViewModel(
            technologiesClientRepository
        ) as T
    }
}