package de.memorian.av.util

import kotlinx.datetime.Instant

/**
 * Converts this [Instant] to a displayable format.
 */
// KotlinX datetime has currently no built in formatter
expect fun Instant.toDisplayableFormat(): String