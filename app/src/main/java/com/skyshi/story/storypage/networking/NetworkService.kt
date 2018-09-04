package com.skyshi.story.storypage.networking

import com.skyshi.story.storypage.model.YoutubeResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET("youtube/v3/search")
    fun getListVideo(@Query("part") part: String,
                     @Query("q") q: String,
                     @Query("type") type: String,
                     @Query("maxResults") maxResult: Int,
                     @Query("pageToken") pageToken: String,
                     @Query("key") key: String)
            : Observable<YoutubeResponse>
}