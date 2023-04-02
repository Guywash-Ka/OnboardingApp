package com.blackpearl.android.onboadingapp.knowledge

class KnowledgeRepository {

    fun getBooks(): List<Book> {
        return listOf(Book(1, "Atlas Shrugged"), Book(2, "Техника безопасности"), Book(3,"Трудовой кодекс РФ"))
    }


    fun getTopics(bookId: Int): List<Topic> {
        return when (bookId) {
            2 -> {
                return listOf(Topic(1,"Общие требования безопасности"),Topic(2,"Требования безопасности перед началом работы"))
            }
            3 -> {
                return listOf(Topic(1, "Раздел 1. Общие положения"),Topic(2,"Раздел 2. Социальное партнерство в сфере труда"),Topic(3,"Трудовой договор"))
            }
            else -> {
                return listOf(Topic(1, "Topic 1"), Topic(2, "Topic 2"), Topic(3, "Topic 3"))
            }
        }
    }

    fun getTheory(bookId: Int, topicId: Int): String {
        return when (bookId) {
            1-> {
                when(topicId) {
                    1-> "CHAPTER I\n" +
                            "\n" +
                            "THE THEME\n" +
                            "\n" +
                            "\"Who is John Galt?\"\n" +
                            "\n" +
                            "The light was ebbing, and Eddie Willers could not distinguish the bum's face. The bum had said it simply, without expression. But from the sunset far at the end of the street, yellow glints caught his eyes, and the eyes looked straight at Eddie Willers, mocking and still—as if the question had been addressed to the causeless uneasiness within him.\n" +
                            "\n" +
                            "\"Why did you say that?\" asked Eddie Willers, his voice tense.\n" +
                            "\n" +
                            "The bum leaned against the side of the doorway; a wedge of broken glass behind him reflected the metal yellow of the sky.\n" +
                            "\n" +
                            "\"Why does it bother you?\" he asked."
                    2-> "CHAPTER II\n" +
                            "\n" +
                            "THE CHAIN\n" +
                            "\n" +
                            "It began with a few lights. As a train of the Taggart line rolled toward Philadelphia, a few brilliant, scattered lights appeared in the darkness; they seemed purposeless in the empty plain, yet too powerful to have no purpose. The passengers watched them idly, without interest.\n" +
                            "\n" +
                            "The black shape of a structure came next, barely visible against the sky, then a big building, close to the tracks; the building was dark, and the reflections of the train lights streaked across the solid glass of its walls."

                    else -> "CHAPTER III\n" +
                            "\n" +
                            "THE TOP AND THE BOTTOM\n" +
                            "\n" +
                            "The ceiling was that of a cellar, so heavy and low that people stooped when crossing the room, as if the weight of the vaulting rested on their shoulders. The circular booths of dark red leather were built into walls of stone that looked eaten by age and dampness. There were no windows, only patches of blue light shooting from dents in the masonry, the dead blue light proper for use in blackouts."
                }
            }
            2-> {
                when(topicId) {
                    1 -> "1.1. Офисный работник обязан соблюдать действующие на предприятии правила внутреннего трудового распорядка и графики работы, которыми предусматривается: время начала и окончания работы (смены), перерывы для отдыха и питания, порядок предоставления дней отдыха, чередование смен и другие вопросы использования рабочего времени. Для целей настоящей Инструкции к офисным работникам относятся: ________________________________________________ _________________________________________________________. (указать должности сотрудников, которые относятся к офисным работникам)\n" +
                            "\n" +
                            " 1.2. Офисный работник обязан: – пользоваться исправными выключателями, розетками, вилками, патронами и другой электроарматурой; – не оставлять без присмотра включенное оборудование и электроприборы, отключать электрическое освещение (кроме аварийного) по окончании работы; – курить только в специально отведенных и оборудованных местах; при использовании в работе горючих и легковоспламеняющихся веществ убирать их в безопасное в пожарном отношении место, не оставлять использованный обтирочный материал в помещении по окончании работы; – соблюдать действующие Правила пожарной безопасности."
                    else -> "2.1. Офисный работник обязан подготовить рабочую зону для безопасной работы: – проверить оснащенность рабочего места; – проверить путем внешнего осмотра достаточность освещенности и исправность выключателей и розеток; – осуществить осмотр электрооборудования (проверку комплектности и надежности крепления деталей; проверку путем внешнего осмотра исправности кабеля (шнура); проверку четкости  работы выключателя; использовать только штатные приспособления).\n" +
                            "\n" +
                            "2.2. Офисный работник обязан доложить руководителю при обнаружении дефектов в электрооборудовании и не эксплуатировать неисправное электрооборудование."
                }
            }
            3-> {
                when(topicId){
                    1-> "ТК РФ Статья 1. Цели и задачи трудового законодательства\n" +
                            "\n" +
                            "Целями трудового законодательства являются установление государственных гарантий трудовых прав и свобод граждан, создание благоприятных условий труда, защита прав и интересов работников и работодателей.\n" +
                            "\n" +
                            "Основными задачами трудового законодательства являются создание необходимых правовых условий для достижения оптимального согласования интересов сторон трудовых отношений, интересов государства, а также правовое регулирование трудовых отношений и иных непосредственно связанных с ними отношений по:\n" +
                            "\n" +
                            "организации труда и управлению трудом;\n" +
                            "\n" +
                            "трудоустройству у данного работодателя;\n" +
                            "\n" +
                            "подготовке и дополнительному профессиональному образованию работников непосредственно у данного работодателя;"
                    2-> "ТК РФ Статья 23. Понятие социального партнерства в сфере труда\n" +
                            "\n" +
                            "(в ред. Федерального закона от 30.06.2006 N 90-ФЗ)\n" +
                            "\n" +
                            "(см. текст в предыдущей редакции)\n" +
                            "\n" +
                            "Социальное партнерство в сфере труда (далее - социальное партнерство) - система взаимоотношений между работниками (представителями работников), работодателями (представителями работодателей), органами государственной власти, органами местного самоуправления, направленная на обеспечение согласования интересов работников и работодателей по вопросам регулирования трудовых отношений и иных непосредственно связанных с ними отношений."
                    else -> ""
                }
            }
            else -> {
                when (topicId) {
                    else -> "Теория которую мы подгружаем откуда-то"
                }
            }
        }
    }
}