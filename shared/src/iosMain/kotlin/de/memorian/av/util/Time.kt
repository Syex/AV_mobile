package de.memorian.av.util

import kotlinx.datetime.Instant

//import platform.Foundation

actual fun Instant.toDisplayableFormat(): String {
    // todo on Mac
//    val dateFormatterGet = DateFormatter()
//    dateFormatterGet.dateFormat = "yyyy-MM-dd HH:mm:ss"
    return toString()
}