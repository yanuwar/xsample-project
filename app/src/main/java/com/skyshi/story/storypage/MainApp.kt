package com.skyshi.story.storypage

import android.app.Application

class MainApp: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {

        var instance: MainApp? = null
            private set
    }
}