package com.org.ageofempires2.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.org.ageofempires2.data.model.aoe2Main.Aoe2MainBase
import com.org.ageofempires2.data.network.RepoClientRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CivilizationsViewModel @Inject constructor(private val repository: RepoClientRepository): ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val aoe2BaseLiveDataSuccess = MutableLiveData<Aoe2MainBase>()
    private val errorObservable = MutableLiveData<String>()


    fun updateAo2Base():MutableLiveData<Aoe2MainBase>{
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