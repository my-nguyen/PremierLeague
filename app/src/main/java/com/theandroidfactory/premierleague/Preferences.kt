package com.theandroidfactory.premierleague

import android.content.Context
import android.content.SharedPreferences

object Preferences {
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences("${BuildConfig.APPLICATION_ID}.shared_2", Context.MODE_PRIVATE)
    }

    fun setFavoriteClub(id: String, value: Boolean) = preferences.edit().putBoolean(id, value).apply()

    fun getFavoriteClub(id: String) = preferences.getBoolean(id, false)

    fun clear() = preferences.edit().clear().apply()
}