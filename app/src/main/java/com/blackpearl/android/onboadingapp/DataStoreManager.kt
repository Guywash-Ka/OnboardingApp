package com.blackpearl.android.onboadingapp

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import java.io.IOException

const val FILENAME = "Settings"

class DataStoreManager(context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = FILENAME)
    private val dataStore = context.dataStore

    private object PreferencesKeys{
        val NAME = stringPreferencesKey("name")
        val DAY = intPreferencesKey("day")
        val ISLAUNCHED = booleanPreferencesKey("isLaunched")
        val POINTS = intPreferencesKey("points")
    }

    suspend fun setName(name: String) {
        dataStore.edit { prefs ->
             prefs[PreferencesKeys.NAME] = name
        }
    }

    suspend fun setDay(level: Int) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.DAY] = level
        }
    }

    suspend fun setIsLaunched(isLaunched: Boolean) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.ISLAUNCHED] = isLaunched
        }
    }

    suspend fun setPoints(points: Int) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.POINTS] = points
        }
    }

    suspend fun getName(): String {
        return dataStore.data.firstOrNull()
            ?.get(PreferencesKeys.NAME)
            .let { it!! }
    }

    suspend fun getDay(): Int {
        return dataStore.data.firstOrNull()
            ?.get(PreferencesKeys.DAY)
            .let { it!! }
    }

    fun getIsLaunched(): Flow<Boolean> {
        return dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
            .map { pref ->
                val isLaunched = pref[PreferencesKeys.ISLAUNCHED] ?: false
                isLaunched
            }
    }

    fun getPoints(): Flow<Int> {
        return dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
            .map { pref ->
                val points = pref[PreferencesKeys.POINTS]?: 0
                points
            }
    }

}