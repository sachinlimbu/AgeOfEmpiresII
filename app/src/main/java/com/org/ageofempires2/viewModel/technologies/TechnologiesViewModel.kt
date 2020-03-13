package com.org.ageofempires2.viewModel.technologies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.org.ageofempires2.data.model.aoe2Main.AoeMainBase
import com.org.ageofempires2.data.network.technologies.TechnologiesClientRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class TechnologiesViewModel @Inject constructor(private val technologiesClientRepository: TechnologiesClientRepository):
    ViewModel(){
    private val compositeDisposable = CompositeDisposable()
    private val aoe2BaseLiveDataSuccess = MutableLiveData<AoeMainBase>()
    private val errorObservable = MutableLiveData<String>()

    fun getTechnologies(isConnected:Boolean){
        val observable = if(isConnected) technologiesClientRepository.getAoe() else technologiesClientRepository.getAeoFromDb()
        compositeDisposable.add(
            observable
                .subscribe(
                    {technology -> aoe2BaseLiveDataSuccess.value = technology},
                    { error -> errorObservable.value = error.message}
                )
        )
    }
    fun updateAo2Base():MutableLiveData<AoeMainBase>{
        return aoe2BaseLiveDataSuccess
    }
    fun getError(): LiveData<String> = errorObservable


    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


}