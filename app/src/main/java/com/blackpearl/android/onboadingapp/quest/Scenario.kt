package com.blackpearl.android.onboadingapp.quest

import android.content.Context
import android.view.ViewGroup

class Scenario(
    private val context: Context,
    private val nextActCallback: (Int) -> Unit,
) {
    private val acts = mutableListOf<Act>()

    fun addAct(configure: (Act) -> Unit): Scenario {
        val act = Act(context, acts.size, nextActCallback)
        configure(act)
        acts += act
        return this
    }

    fun size() = acts.size

    fun getAct(index: Int) = acts[index]
}
