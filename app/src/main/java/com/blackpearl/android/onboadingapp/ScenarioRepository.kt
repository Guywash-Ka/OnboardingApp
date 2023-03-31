package com.blackpearl.android.onboadingapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class Scenario(
    private val context: Context,
    private val nextActCallback: (Int) -> Unit
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

class Act(
    private val context: Context,
    private val index: Int,
    private val nextActCallback: (Int) -> Unit
) {

    private val views = mutableListOf<View>()

    fun addNarrator(txt: String): Act {

        val textView = TextView(context).apply {
            text = txt

            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

        }

        views += textView

        return this
    }

    fun addNextButton(txt: String): Act {

        val button = Button(context).apply {
            text = txt

            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            setOnClickListener {
                nextActCallback(index+1)
            }
        }

        views += button

        return this
    }

    fun addNarrator(textStringRes: Int): Act {
        return this
    }

    fun getViews(): List<View> = views
}

class ScenarioRepository(
    private val context: Context,
    private val nextActCallback: (Int) -> Unit
) {

    fun getScenario(day: Int): Scenario {

        return when (day) {
            1 -> {
                Scenario(context, nextActCallback)
                    .addAct {
                        it.addNarrator("Hello")
                        it.addNextButton("Understood")
                    }
                    .addAct {
                        it.addNarrator("Goodbye")
                        it.addNextButton("Okay")
                    }
            }

            else -> {

                Scenario(context, nextActCallback)
                    .addAct {
                        it.addNarrator("This is the end")
                    }
            }

        }
    }

}