package com.skyshi.story.storypage.exception

import java.io.IOException

/**
 * Created by yusufaw on 2/20/18.
 */

class ErrorConnectionException : IOException {

    constructor() : super("No Connection, Please check your connection")

    constructor(message: String) : super(message)
}
