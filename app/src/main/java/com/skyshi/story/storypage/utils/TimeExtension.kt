package com.skyshi.story.storypage.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.toSimpleMonthString(locale: Locale): String = SimpleDateFormat("dd MMM yyyy", locale).format(this)
fun Date.toFullMonthString(locale: Locale): String = SimpleDateFormat("dd MMMM yyyy", locale).format(this)
fun Date.toSimpleDateString(locale: Locale): String = SimpleDateFormat("yyyy-MM-dd", locale).format(this)
fun Date.toSimpleTimeWithoutSecond(locale: Locale): String = SimpleDateFormat("HH:mm", locale).format(this)
fun Date.toSimpleTimeWithoutSecondAmPm(locale: Locale): String = SimpleDateFormat("hh:mm a", locale).format(this)
fun String.simpleToDate(locale: Locale): Date = SimpleDateFormat("yyyy-MM-dd", locale).parse(this)
fun String.simpleMonthToDate(locale: Locale): Date = SimpleDateFormat("dd MMM yyyy", locale).parse(this)
fun String.simpleTimeToDateWithoutSecond(locale: Locale): Date = SimpleDateFormat("HH:mm", locale).parse(this)
fun String.fullDateTimeToDateWithoutSecond(locale: Locale): Date = SimpleDateFormat("yyyy-MM-dd HH:mm", locale).parse(this)
fun String.simpleTimeToDate(locale: Locale): Date = SimpleDateFormat("HH:mm", locale).parse(this)
fun String.simpleToSimpleMonthString(locale: Locale): String {
    return this.simpleToDate(locale)
            .toSimpleMonthString(locale)
}
fun String.simpleMonthToSimpleDateString(locale: Locale): String {
    return SimpleDateFormat("dd MMM yyyy", locale).parse(this)
            .toSimpleDateString(locale)
}
fun String.fullToFullMonthString(locale: Locale): String {
    return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", locale).parse(this)
            .toFullMonthString(locale)
}
fun String.convertTimeToAmPm(locale: Locale): String {
    return SimpleDateFormat("hh:mm a", locale)
            .format(SimpleDateFormat("HH:mm:ss", locale).parse(this))
}
fun String.convertTime24(locale: Locale): String {
    return SimpleDateFormat("HH:mm", locale)
            .format(SimpleDateFormat("HH:mm:ss", locale).parse(this))
}