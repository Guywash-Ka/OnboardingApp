package com.blackpearl.android.onboadingapp.quiz

import androidx.annotation.StringRes


data class Question(@StringRes val questionResId: Int,val answers: Answers,val type: Int)