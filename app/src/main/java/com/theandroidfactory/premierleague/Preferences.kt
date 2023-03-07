package com.theandroidfactory.premierleague

import android.content.Context
import android.content.SharedPreferences

object Preferences {
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences("${BuildConfig.APPLICATION_ID}.shared_preferences", Context.MODE_PRIVATE)
    }

    fun setFavoriteClub(id: String, value: Boolean) = setBoolean(id, value)

    fun getFavoriteClub(id: String) = getBoolean(id)

    private fun setBoolean(name: String, value: Boolean) = preferences.edit().putBoolean(name, value).apply()

    private fun getBoolean(name: String) = preferences.getBoolean(name, false)
}