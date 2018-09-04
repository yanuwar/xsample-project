package com.skyshi.story.storypage.utils

import android.view.View

/**
 * set visible view
 */
fun View.toVisible() {
    visibility = View.VISIBLE
}
/**
 * set gone
 */
internal fun View.toGone() {
    visibility = View.GONE
}
/**
 * set gone
 */
internal fun View.toInvisible() {
    visibility = View.INVISIBLE
}
/**
 * check visible
 */
internal fun View.isVisible() : Boolean {
    return visibility == View.VISIBLE
}
/**
 * set visible view
 */
internal fun View.toEnable() {
    isEnabled = true
}
/**
 * set gone
 */
internal fun View.toDisable() {
    isEnabled = false
}