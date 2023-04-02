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
                        it.useNarratorScene("Привет. Текст", "Да", R.drawable.merlin)
                    }.addAct {
                        it.useNarratorScene("Еще текст", "Ого", R.drawable.putin1)
                    }.addAct {
                        it.useNarratorScene("Читай", "Я готов", R.drawable.putin1)
                    }.addAct {
                        it.useTextScene("Не то чтоб он был так труслив и забит, совсем даже напротив; но с некоторого времени он был в раздражительном и напряженном состоянии, похожем на ипохондрию. Он до того углубился в себя и уединился от всех, что боялся даже всякой встречи, не только встречи с хозяйкой. Он был задавлен бедностью; но даже стесненное положение перестало в последнее время тяготить его. Насущными делами своими он совсем перестал и не хотел заниматься. Никакой хозяйки, в сущности, он не боялся, что бы та ни замышляла против него. Но останавливаться на лестнице, слушать всякий вздор про всю эту обыденную дребедень, до которой ему нет никакого дела, все эти приставания о платеже, угрозы, жалобы, и при этом самому изворачиваться, извиняться, лгать, — нет уж, лучше проскользнуть как-нибудь кошкой по лестнице и улизнуть, чтобы никто не видал.\n" +
                                "Впрочем, на этот раз страх встречи с своею кредиторшей даже его самого поразил по выходе на улицу.", "Интересно")
                    }.addAct {
                        it.useNarratorScene("Все понятно? Готов к тесту?", "Блин", R.drawable.putin1)
                        it.addTest(1)
                    }.addAct {
                        it.useNarratorScene("Отлично, а теперь текст.", "Да", R.drawable.putin2)
                    }.addAct {
                        it.useImageTextScene("Посмотрите это же картинка", "А это текст после картинки", R.drawable.putin2, "Понятно")
                    }.addAct {
                        it.useNarratorScene("Еще один тест", "Я рад", R.drawable.putin2)
                        it.addTest(2)
                    }.addAct {
                        it.useNarratorScene("День закончен", "Выдохнули", R.drawable.putin2)
                    }

            }


            else -> {
                Scenario(context, nextActCallback)
                    .addAct {
                        it.useNarratorScene("Привет. Текст", "Да", R.drawable.cat)
                    }.addAct {
                        it.useNarratorScene("Еще текст", "Ого", R.drawable.cat)
                    }.addAct {
                        it.useNarratorScene("Читай", "Я готов", R.drawable.cat)
                    }.addAct {
                        it.useTextScene("Не то чтоб он был так труслив и забит, совсем даже напротив; но с некоторого времени он был в раздражительном и напряженном состоянии, похожем на ипохондрию. Он до того углубился в себя и уединился от всех, что боялся даже всякой встречи, не только встречи с хозяйкой. Он был задавлен бедностью; но даже стесненное положение перестало в последнее время тяготить его. Насущными делами своими он совсем перестал и не хотел заниматься. Никакой хозяйки, в сущности, он не боялся, что бы та ни замышляла против него. Но останавливаться на лестнице, слушать всякий вздор про всю эту обыденную дребедень, до которой ему нет никакого дела, все эти приставания о платеже, угрозы, жалобы, и при этом самому изворачиваться, извиняться, лгать, — нет уж, лучше проскользнуть как-нибудь кошкой по лестнице и улизнуть, чтобы никто не видал.\n" +
                                "Впрочем, на этот раз страх встречи с своею кредиторшей даже его самого поразил по выходе на улицу.", "Интересно")
                    }.addAct {
                        it.useNarratorScene("Все понятно? Готов к тесту?", "Блин", R.drawable.cat)
                        it.addTest(1)
                    }.addAct {
                        it.useNarratorScene("Отлично, а теперь текст.", "Да", R.drawable.cat_2)
                    }.addAct {
                        it.useImageTextScene("Посмотрите это же картинка", "А это текст после картинки", R.drawable.cat_2, "Понятно")
                    }.addAct {
                        it.useNarratorScene("Еще один тест", "Я рад", R.drawable.cat_2)
                        it.addTest(2)
                    }.addAct {
                        it.useNarratorScene("День закончен", "Выдохнули", R.drawable.cat_2)
                    }

            }

        }
    }

    fun getColleagues(): Scenario {
        return Scenario(context, nextActCallback)
            .addAct {
                it.useNarratorScene("Сан Саныч", "Приятно познакомится!")
            }.addAct {
                it.useNarratorScene("Злодей британец", "Приятно познакомится!")
            }.addAct {
                it.useNarratorScene("То", "Приятно познакомится!")
            }.addAct {
                it.useNarratorScene("Сан Саныч", "Приятно познакомится!")
            }.addAct {
                it.useNarratorScene("Сан Саныч", "Приятно познакомится!")
            }.addAct {
                it.useNarratorScene("Сан Саныч", "Приятно познакомится!")
            }.addAct {
                it.useNarratorScene("Сан Саныч", "Приятно познакомится!")
            }
    }
}