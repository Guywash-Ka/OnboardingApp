package com.blackpearl.android.onboadingapp

import android.content.Context
import com.blackpearl.android.onboadingapp.quest.Scenario

class ScenarioRepository(
    private val context: Context,
    private val nextActCallback: (Int) -> Unit
) {

    fun getScenario(day: Int): Scenario {


        return when (day) {
            1 -> {
                Scenario(context, nextActCallback)
                    .addAct {
                        it.useNarratorScene("Привет. Я буду Твоим помощником в адаптиции к новой среде и компании!" +
                                " Чтобы получить максимальную пользу от обучения, " +
                                "старайся внимательно читать теорию и проходить все тесты",
                            "Понял! Что дальше?", R.drawable.chel1)
                    }.addAct {
                        it.useNarratorScene("Сейчас я расскажу тебе про наша компанию, а после ты сможешь пройти небольшой тест по полученным знаниям", "Вперед", R.drawable.chel2)
                    }.addAct {
                        it.useNarratorScene("Наша компания очень быстро развивается, а следовательно и наши технологии", "Ок", R.drawable.chel3)
                    }.addAct {
                        it.useTextScene("Интересный факт: Компания начала свою деятельность аж в 2008 году, а уже в 2019 году компания заключила уже более 10 контрактов по 44 и 223-ФЗ на общую сумму более 61 млн рублей.", "Круто!")
                    }.addAct {
                        it.useNarratorScene("Все понятно? Готов к тесту?", "Да", R.drawable.chel3)
                        it.addTest(1)
                    }.addAct {
                        it.useNarratorScene("Отлично, Поехали дальше", "Да", R.drawable.chel2)
                    }.addAct {
                        it.useImageTextScene("Сейчас я познакомлю тебя с нашей внутренней системой для совместной работы. Например аналитика по проекту", "Тут я должен рассказать тебе больше, но я лишь демо-версия :)", R.drawable.anal, "Жаль")
                    }.addAct {
                        it.useNarratorScene("Давай пройдем еще один тест", "Хорошо", R.drawable.chel1)
                        it.addTest(2)
                    }.addAct {
                        it.useNarratorScene("День закончен", "Выдохнули", R.drawable.chelok)
                    }

            }


            -1 -> {
                Scenario(context, nextActCallback)
                    .addAct {
                        it.useNarratorScene("Игорь\n" +
                                "Умеет то и се", "Приятно познакомится")
                    }.addAct {
                        it.useNarratorScene("Райан Гослинг", "Приятно познакомится")
                    }.addAct {
                        it.useNarratorScene("Игорь\n" +
                                "Умеет то и се", "Приятно познакомится")
                    }.addAct {
                        it.useNarratorScene("Игорь\n" +
                                "Умеет то и се", "Приятно познакомится")
                    }
            }

            else -> {
                Scenario(context, nextActCallback)
                    .addAct {
                        it.useNarratorScene("Привет. Я буду Твоим помощником в адаптиции к новой среде и компании!" +
                                " Чтобы получить максимальную пользу от обучения, " +
                                "старайся внимательно читать теорию и проходить все тесты",
                            "Понял! Что дальше?", R.drawable.chel1)
                    }.addAct {
                        it.useNarratorScene("Сейчас я расскажу тебе про наша компанию, а после ты сможешь пройти небольшой тест по полученным знаниям", "Вперед", R.drawable.chel2)
                    }.addAct {
                        it.useNarratorScene("Наша компания очень быстро развивается, а следовательно и наши технологии", "Ок", R.drawable.chel3)
                    }.addAct {
                        it.useTextScene("Интересный факт: Компания начала свою деятельность аж в 2008 году, а уже в 2019 году компания заключила уже более 10 контрактов по 44 и 223-ФЗ на общую сумму более 61 млн рублей.", "Круто!")
                    }.addAct {
                        it.useNarratorScene("Все понятно? Готов к тесту?", "Да", R.drawable.chel3)
                        it.addTest(1)
                    }.addAct {
                        it.useNarratorScene("Отлично, Поехали дальше", "Да", R.drawable.chel2)
                    }.addAct {
                        it.useImageTextScene("Сейчас я познакомлю тебя с нашей внутренней системой для совместной работы. Например аналитика по проекту", "Тут я должен рассказать тебе больше, но я лишь демо-версия :)", R.drawable.anal, "Жаль")
                    }.addAct {
                        it.useNarratorScene("Давай пройдем еще один тест", "Хорошо", R.drawable.chel1)
                        it.addTest(2)
                    }.addAct {
                        it.useNarratorScene("День закончен", "Выдохнули", R.drawable.chelok)
                    }

            }


        }
    }

}