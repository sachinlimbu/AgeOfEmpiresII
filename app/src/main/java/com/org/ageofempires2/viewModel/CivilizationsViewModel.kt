package com.org.ageofempires2.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.org.ageofempires2.data.network.RepoClientRepository
import javax.inject.Inject

class Aoe2ViewModel @Inject constructor(private val repository: RepoClientRepository): ViewModel() {

}