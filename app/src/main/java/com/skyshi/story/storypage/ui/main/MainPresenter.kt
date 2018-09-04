package com.skyshi.story.storypage.ui.main

import com.skyshi.skymvp.BasePresenter2
import com.skyshi.skymvp.BaseView
import com.skyshi.story.storypage.model.YoutubeResponse
import com.skyshi.story.storypage.networking.Service
import javax.inject.Inject

class MainPresenter @Inject constructor(private val service: Service) : BasePresenter2<MainPresenter.MainView>()  {
    fun addToItinerary(query: String, pageToken: String) {
        view?.showWait()
        service.getVideoYou(query, pageToken).subscribe({ result ->
            view?.removeWait()
            view?.successGetDataVideo(result)
        }, { error ->
            view?.removeWait()
            view?.onFailure(error.message.toString())
        })
    }
    interface MainView: BaseView {
        fun successGetDataVideo(youtubeResponse: YoutubeResponse)
    }
}