package com.theandroidfactory.premierleague

import android.app.Application

class MyApplication: Application() {
    companion object {
        lateinit var application: Application
    }

    override fun onCreate() {
        super.onCreate()

        application = this
        Preferences.init(this)
    }
}