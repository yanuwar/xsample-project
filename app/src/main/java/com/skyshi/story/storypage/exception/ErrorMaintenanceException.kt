package com.skyshi.story.storypage.exception

import java.io.IOException

class ErrorMaintenanceException: IOException {

    constructor() : super("Maintenance Mode")

    constructor(message: String) : super(message)
}