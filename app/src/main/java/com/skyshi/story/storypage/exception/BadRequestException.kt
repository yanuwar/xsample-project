package com.skyshi.story.storypage.exception

import com.google.gson.JsonObject
import java.io.IOException

class BadRequestException(val errorResponse: JsonObject, message: String?) : IOException(message)