package com.org.ageofempires2.viewModel.civilization

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase
import com.org.ageofempires2.data.network.civilization.CivilizationClientRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CivilizationsViewModel @Inject constructor(private val repository: CivilizationClientRepository): ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val aoe2BaseLiveDataSuccess = MutableLiveData<AoeMainBase>()
    private val errorObservable = MutableLiveData<String>()



    fun getCivlization(isConnected:Boolean){
        val observable = if(isConnected) repository.getAoe() else repository.getAeoFromDb()
        compositeDisposable.add(
            observable
                .subscribe(
                    {civilizations -> aoe2BaseLiveDataSuccess.value = civilizations},
                    { error -> errorObservable.value = error.message}
                )
        )
    }

    fun updateAo2Base():MutableLiveData<AoeMainBase>{
        return aoe2BaseLiveDataSuccess
    }
    fun getError():LiveData<String> = errorObservable


    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}