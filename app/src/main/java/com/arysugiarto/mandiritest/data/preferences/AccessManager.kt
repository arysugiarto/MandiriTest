package com.arysugiarto.mandiritest.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.arysugiarto.mandiritest.util.emptyString
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import timber.log.Timber
import java.util.*

class AccessManager(private val context: Context) {

    val access: Flow<String> = context.dataStore.data
            .catch { throwable ->
                emit(emptyPreferences())
                Timber.e(throwable)
            }.map { preferences ->
                preferences[PreferencesKey.accessKey] ?: emptyString
            }

    val sessionId: Flow<String> = context.dataStore.data
        .catch { throwable ->
            emit(emptyPreferences())
            Timber.e(throwable)
        }.map { preferences ->
            preferences[PreferencesKey.sessionIdKey] ?: emptyString
        }

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
            name = PreferencesKey.AUTH_PREFERENCES_KEY.toUpperCase(Locale.ROOT)
        )
    }

    private object PreferencesKey {
        const val AUTH_PREFERENCES_KEY = "auth_preferences"
        const val TOKEN_ACCESS_REF = "token_access_key"
        const val SESSION_ID_REF = "session_id_reference_key"

        val accessKey = stringPreferencesKey(TOKEN_ACCESS_REF)
        val sessionIdKey = stringPreferencesKey(SESSION_ID_REF)
    }
}
