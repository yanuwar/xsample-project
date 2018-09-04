package com.skyshi.story.storypage.networking

import com.skyshi.skymvp.RxUtils
import com.skyshi.story.storypage.model.YoutubeResponse
import com.skyshi.story.storypage.preferences.PreferencesUtil
import io.reactivex.Observable
import javax.inject.Inject

class Service @Inject constructor(private val networkService: NetworkService, private val preferencesUtil: PreferencesUtil) {
    fun getVideoYou(query: String, pageToken: String): Observable<YoutubeResponse> {
        return networkService.getListVideo("snippet",query,"video",10,pageToken,"AIzaSyA0P4qDtyo8NO627lEIZ_Y1anCRiIZJjnM")
                .compose(RxUtils.applyObservableAsync())
    }
}