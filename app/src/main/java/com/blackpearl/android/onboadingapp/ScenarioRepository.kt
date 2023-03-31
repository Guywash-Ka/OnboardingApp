package com.blackpearl.android.onboadingapp

import android.content.Context
import android.view.ViewGroup
import com.blackpearl.android.onboadingapp.quest.Scenario

class ScenarioRepository(
    private val context: Context,
    private val nextActCallback: (Int) -> Unit
) {

    fun getScenario(day: Int): Scenario {

        val str = "В начале июля, в чрезвычайно жаркое время, под вечер, один молодой человек вышел из своей каморки, которую нанимал от жильцов в С — м переулке, на улицу и медленно, как бы в нерешимости, отправился к К — ну мосту.\n" +
                "Он благополучно избегнул встречи с своею хозяйкой на лестнице. Каморка его приходилась под самою кровлей высокого пятиэтажного дома и походила более на шкаф, чем на квартиру. Квартирная же хозяйка его, у которой он нанимал эту каморку с обедом и прислугой, помещалась одною лестницей ниже, в отдельной квартире, и каждый раз, при выходе на улицу, ему непременно надо было проходить мимо хозяйкиной кухни, почти всегда настежь отворенной на лестницу. И каждый раз молодой человек, проходя мимо, чувствовал какое-то болезненное и трусливое ощущение, которого стыдился и от которого морщился. Он был должен кругом хозяйке и боялся с нею встретиться.\n"

        return when (day) {
            1 -> {
                Scenario(context, nextActCallback)
                    .addAct {
                        it.addNarrator(str, "go go go", R.drawable.cat)
                    }.addAct {
                        it.addNarrator("Act II. Zaebis", "Da", R.drawable.cat_2)
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