package com.blackpearl.android.onboadingapp.quiz
private const val TYPE1_ANSWERS_LIST = 0
private const val RIGHT_ANSWER = 1

class Answers() {
    private val map =  mutableMapOf<Int,Any>()

    fun putAnswers(answers: List<Int>) {
        map[TYPE1_ANSWERS_LIST] = answers
    }

    fun getAnswers(): List<Int> {
        return map[TYPE1_ANSWERS_LIST] as List<Int>
    }

    fun putRightAnswer(answer: Int) {
        map[RIGHT_ANSWER] = answer
    }

    fun getRightAnswer(): Int {
        return map[RIGHT_ANSWER] as Int
    }


}