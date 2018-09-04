package com.skyshi.story.storypage.model

class YoutubeResponse (
        val nextPageToken: String?,
        val prevPageToken: String?,
        val page: PageInfo?,
        val items: MutableList<ItemYoutube>?
)