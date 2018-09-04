package com.skyshi.story.storypage.deps

import com.skyshi.story.storypage.BaseApp
import com.skyshi.story.storypage.networking.NetworkModule
import com.skyshi.story.storypage.preferences.PreferencesModule
import com.skyshi.story.storypage.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PreferencesModule::class, NetworkModule::class])
interface Deps {
    fun inject(mainActivity: MainActivity)
    fun inject(baseApp: BaseApp)
}