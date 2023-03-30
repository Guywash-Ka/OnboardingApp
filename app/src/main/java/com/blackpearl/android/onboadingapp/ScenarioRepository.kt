package com.blackpearl.android.onboadingapp

import android.content.Context
import android.view.ViewGroup
import com.blackpearl.android.onboadingapp.quest.Scenario

class ScenarioRepository(
    private val context: Context,
    private val nextActCallback: (Int) -> Unit
) {

    fun getScenario(day: Int): Scenario {

        return when (day) {
            1 -> {
//                Scenario(context, nextActCallback)
//                    .addAct {
//                        it.addNarrator("Hello")
//                        it.addNextButton("Understood")
//                    }
//                    .addAct {
//                        it.addNarrator("Goodbye")
//                        it.addNextButton("Okay")
//                    }

                Scenario(context, nextActCallback)
                    .addAct {
                        it.addNarrator("Act I. Pizdec", "go go go")
                    }.addAct {
                        it.addNarrator("Act II. Zaebis", "Da")
                    }
            }

            else -> {

                Scenario(context, nextActCallback)
                    .addAct {
                        it.addNarrator("Act III. Pizdec", "go go go")
                    }.addAct {
                        it.addNarrator("Act IIVDFSD. Zaebis", "Da")
                    }
            }

        }
    }

}