package com.blackpearl.android.onboadingapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QuestViewModel : ViewModel() {
    private var actIndex: Int = 0

    fun getActIndex() = actIndex
    fun updateIndex(newIndex: Int) {
        actIndex = newIndex
    }
}