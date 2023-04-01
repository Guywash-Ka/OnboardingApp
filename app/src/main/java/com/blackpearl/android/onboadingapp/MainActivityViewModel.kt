package com.blackpearl.android.onboadingapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class MainUiState(
    val name: String = "Александр Алексеев",
    val isLaunched: Boolean = false,
    val points: Int = 1,
    val day: Int = 1
)

class MainActivityViewModel: ViewModel() {
    private val dataStore = DataStoreRepository.get()

    private val _uiState: MutableStateFlow<MainUiState> =
        MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            dataStore.name.collect { name ->
                _uiState.update { it.copy(name = name) }
            }
        }

        viewModelScope.launch {
            dataStore.isLaunched.collect { isLaunched ->
                _uiState.update { it.copy(isLaunched = isLaunched) }
            }
        }

        viewModelScope.launch {
            dataStore.day.collect { day ->
                _uiState.update { it.copy(day = day) }
            }
        }

        viewModelScope.launch {
            dataStore.points.collect { points ->
                _uiState.update { it.copy(points = points) }
            }
        }
    }

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

    fun setDay(day: Int) {
        viewModelScope.launch {
            dataStore.setDay(day)
        }
    }

}