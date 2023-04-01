package com.blackpearl.android.onboadingapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    val dataStore = DataStoreManager(application)
    val getIsLaunched = dataStore.getIsLaunched().asLiveData(Dispatchers.IO)
    val getPoints = dataStore.getPoints().asLiveData(Dispatchers.IO)

    fun setIsLaunched(isLaunched: Boolean) {
        viewModelScope.launch {
            dataStore.setIsLaunched(isLaunched)
        }
    }

    fun setPoints(points: Int) {
        viewModelScope.launch {
            dataStore.setPoints(points)
        }
    }

    fun setName(name: String) {
        viewModelScope.launch {
            dataStore.setName(name)
        }
    }

}