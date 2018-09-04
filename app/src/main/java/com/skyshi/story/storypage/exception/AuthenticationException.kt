package com.skyshi.story.storypage.exception

import java.io.IOException

class AuthenticationException : IOException {

    constructor() : super("Unauthorized")

    constructor(message: String) : super(message)
}
