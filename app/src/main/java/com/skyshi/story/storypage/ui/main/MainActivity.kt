package com.skyshi.story.storypage.ui.main

import android.os.Bundle
import android.util.Log.e
import com.google.gson.Gson
import com.skyshi.story.storypage.BaseApp
import com.skyshi.story.storypage.R
import com.skyshi.story.storypage.model.YoutubeResponse
import com.skyshi.story.storypage.preferences.PreferencesUtil
import javax.inject.Inject

class MainActivity : BaseApp(), MainPresenter.MainView {
    @Inject
    lateinit var preferencesUtil: PreferencesUtil
    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        deps.inject(this)
        presenter.attachView(this)

        presenter.addToItinerary("java", "")
    }

    override fun successGetDataVideo(youtubeResponse: YoutubeResponse) {
        e("cihuy", Gson().toJson(youtubeResponse))
    }

    override fun onFailure(appErrorMessage: String) {
    }

    override fun removeWait() {
    }

    override fun showWait() {
    }
}
