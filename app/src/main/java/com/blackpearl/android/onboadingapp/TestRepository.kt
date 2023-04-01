package com.blackpearl.android.onboadingapp

import android.content.Context
import com.blackpearl.android.onboadingapp.quest.Scenario
import com.blackpearl.android.onboadingapp.quiz.Answers
import com.blackpearl.android.onboadingapp.quiz.Question


class TestRepository() {

    fun getTest(id:Int): List<Question> {
        return when (id)
        {
            1-> {
                val answers1 = Answers().apply {
                    putAnswers(listOf(R.string.answer1_capital_of_australia,R.string.answer2_capital_of_australia,R.string.answer3_capital_of_australia,R.string.answer4_capital_of_australia))
                    putRightAnswer(R.string.answer2_capital_of_australia)
                }
                val answers2 = Answers().apply {
                    putAnswers(listOf(R.string.answer1_largest_ocean,R.string.answer2_largest_ocean,R.string.answer3_largest_ocean))
                    putRightAnswer(R.string.answer1_largest_ocean)
                }
                listOf(
                    Question(R.string.question_capital_of_australia,answers1,1),
                    Question(R.string.question_largest_ocean,answers2,2)

                )
            }
            else -> {
                val answersMath = Answers().apply {
                    putAnswers(listOf(R.string.answer1_2plus2,R.string.answer2_2plus2,R.string.answer3_2plus2))
                    putRightAnswer(R.string.answer3_2plus2)
                }
                listOf(
                    Question(R.string.question_2plus2, answersMath,1)
                )
            }
        }
    }
}