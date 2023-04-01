package com.blackpearl.android.onboadingapp.knowledge

class KnowledgeRepository {

    fun getBooks(): List<Book> {
        return listOf(Book(1, "Atlas Shrugged"), Book(2, "The Fountainhead"))
    }


    fun getTopics(bookId: Int): List<Topic> {
        return when (bookId) {
            else -> {
                return listOf(Topic(1, "Topic 1"), Topic(2, "Topic 2"), Topic(3, "Topic 3"))
            }
        }
    }

    fun getTheory(bookId: Int, topicId: Int): String {
        return when (bookId) {
            else -> {
                when (topicId) {
                    else -> "Теория которую мы подгружаем откуда-то"
                }
            }
        }
    }
}