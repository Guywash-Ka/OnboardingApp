package com.blackpearl.android.onboadingapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blackpearl.android.onboadingapp.quiz.Answers


class QuizViewModel(testId: Int) : ViewModel() {
    private val testRepository = TestRepository()

    val test = testRepository.getTest(testId)

    var currentIndex = 0

    val currentQuestionResId : Int
    get() = test[currentIndex].questionResId

    val currentQuestionType: Int
    get() = test[currentIndex].type

    val currentQuestionAnswers: Answers
    get() = test[currentIndex].answers

    var points = 0

}

class QuizViewModelFactory (private val testId: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuizViewModel(testId) as T
    }
}