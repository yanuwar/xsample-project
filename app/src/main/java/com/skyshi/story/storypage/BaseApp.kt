package com.skyshi.story.storypage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.skyshi.story.storypage.deps.DaggerDeps
import com.skyshi.story.storypage.deps.Deps
import com.skyshi.story.storypage.networking.NetworkModule
import com.skyshi.story.storypage.preferences.PreferencesModule
import java.io.File

open class BaseApp: AppCompatActivity() {
    lateinit var deps: Deps

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cacheFile = File(cacheDir, "responses")
        deps = DaggerDeps
                .builder()
                .networkModule(NetworkModule(application, cacheFile))
                .preferencesModule(PreferencesModule(application))
                .build()
        deps.inject(this)
    }
}