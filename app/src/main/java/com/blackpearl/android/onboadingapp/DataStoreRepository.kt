package com.blackpearl.android.onboadingapp

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStoreFile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreRepository private constructor(
    private val dataStore: DataStore<Preferences>
){
    val name: Flow<String> = dataStore.data.map {
        it[NAME] ?: "Алекс Алексеев"
    }

    val day: Flow<Int> = dataStore.data.map {
        it[DAY] ?: 1
    }

    val isLaunched: Flow<Boolean> = dataStore.data.map {
        it[ISLAUNCHED] ?: false
    }

    val points: Flow<Int> = dataStore.data.map {
        it[POINTS] ?: 0
    }

    suspend fun setName(name: String) {
        dataStore.edit {
            it[NAME] = name
        }
    }

    suspend fun setDay(level: Int) {
        dataStore.edit {
            it[DAY] = level
        }
    }

    suspend fun setIsLaunched(isLaunched: Boolean) {
        dataStore.edit {
            it[ISLAUNCHED] = isLaunched
        }
    }

    suspend fun setPoints(points: Int) {
        dataStore.edit {
            it[POINTS] = points
        }
    }

    companion object PreferencesKeys{
        private val NAME = stringPreferencesKey("name")
        private val DAY = intPreferencesKey("day")
        private val ISLAUNCHED = booleanPreferencesKey("isLaunched")
        private val POINTS = intPreferencesKey("points")

        private var INSTANCE: DataStoreRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                val dataStore = PreferenceDataStoreFactory.create {
                    context.preferencesDataStoreFile("Settings")
                }
                INSTANCE = DataStoreRepository(dataStore)
            }
        }

        fun get(): DataStoreRepository {
            return INSTANCE ?: throw IllegalStateException(
                "DataStoreRepository must be initialized"
            )
        }

    }
}