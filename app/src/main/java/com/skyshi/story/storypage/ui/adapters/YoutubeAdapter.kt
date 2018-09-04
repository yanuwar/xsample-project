package com.skyshi.story.storypage.ui.adapters

import android.content.Context
import com.skyshi.skymvp.SkyAdapter
import com.skyshi.skymvp.SkyViewHolder
import com.skyshi.story.storypage.model.ItemYoutube
import com.skyshi.story.storypage.model.YoutubeResponse
import com.skyshi.story.storypage.preferences.PreferencesUtil
import javax.inject.Inject

class YoutubeAdapter@Inject constructor(private val context: Context? , private val preferencesUtil: PreferencesUtil) :
        SkyAdapter<ItemYoutube, SkyViewHolder<ItemYoutube>>() {
}