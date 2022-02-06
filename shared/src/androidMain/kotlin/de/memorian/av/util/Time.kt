package de.memorian.av.util

import kotlinx.datetime.Instant
import kotlinx.datetime.toJavaInstant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

actual fun Instant.toDisplayableFormat(): String {
    val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
        .withLocale(Locale.getDefault())
        .withZone(ZoneId.systemDefault())

    return formatter.format(this.toJavaInstant())
}