package com.blackpearl.android.onboadingapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blackpearl.android.onboadingapp.quiz.Answers

class TestPassedViewModel(private val testId: Int,
                          private val testResult: Int,
                          private val rightAnswers: Int,
                          private val questionAmount: Int): ViewModel() {
    fun getArguments() : List<Int> {
        return listOf(rightAnswers,questionAmount,testResult)
    }
    fun getTestId() = testId
}

class TestPassedViewModelFactory (private val testId: Int,
                                  private val testResult: Int,
                                  private val rightAnswers: Int,
                                  private val questionAmount: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TestPassedViewModel(testId,testResult,rightAnswers,questionAmount) as T
    }
}