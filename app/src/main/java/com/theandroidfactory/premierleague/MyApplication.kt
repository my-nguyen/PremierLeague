package com.theandroidfactory.premierleague

import android.app.Application

class MyApplication: Application() {
    companion object {
        lateinit var app: MyApplication
        lateinit var clubs: List<Club>
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }
}