package com.bhiapps.cricutandroidquiz.utils

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "quiz_data_store")

class DataStoreManager(context: Context) {
    private val dataStore = context.dataStore

    companion object {
        private val HIGH_SCORE = intPreferencesKey("high_score")
    }

    suspend fun saveNewHighScore(value: Int) {
        dataStore.edit { pref ->
            println(pref[HIGH_SCORE])
            pref[HIGH_SCORE] = value
            println(pref[HIGH_SCORE])
        }
    }

    val highScore: Flow<Int> = dataStore.data
        .map { pref ->
            pref[HIGH_SCORE] ?: 0
        }
}