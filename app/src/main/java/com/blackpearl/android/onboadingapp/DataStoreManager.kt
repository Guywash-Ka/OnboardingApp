package com.blackpearl.android.onboadingapp

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

const val FILENAME = "Settings"

class DataStoreManager(context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = FILENAME)
    private val dataStore = context.dataStore

    private object PreferencesKeys{
        val NAME = stringPreferencesKey("name")
        val LEVEL = intPreferencesKey("level")
    }

    suspend fun saveName(name: String) {
        dataStore.edit { prefs ->
             prefs[PreferencesKeys.NAME] = name
        }
    }

    suspend fun saveLevel(level: Int) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.LEVEL] = level
        }
    }

    suspend fun getName(): String {
        return dataStore.data.firstOrNull()
            ?.get(PreferencesKeys.NAME).let { it!! }
    }

    suspend fun getLevel(): Int {
        return dataStore.data.firstOrNull()
            ?.get(PreferencesKeys.LEVEL)
            .let { it!! }
    }

}