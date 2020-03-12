package com.org.ageofempires2.viewModel.civilization

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase
import com.org.ageofempires2.data.network.RepoClientRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CivilizationsViewModel @Inject constructor(private val repository: RepoClientRepository): ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val aoe2BaseLiveDataSuccess = MutableLiveData<AoeMainBase>()
    private val errorObservable = MutableLiveData<String>()


    fun updateAo2Base():MutableLiveData<AoeMainBase>{
        return aoe2BaseLiveDataSuccess
    }

    fun getCivlization(){
        compositeDisposable.add(
            repository.getAoe2()
                .subscribe(
                    {civilizations -> aoe2BaseLiveDataSuccess.value = civilizations},
                    { error -> errorObservable.value = error.message}
                )
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}