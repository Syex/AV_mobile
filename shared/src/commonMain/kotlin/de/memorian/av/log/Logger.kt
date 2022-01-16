package de.memorian.av.log

import de.memorian.av.log.LogLevel.*

inline fun <reified T> T.logTag(): String = T::class.simpleName!!

inline fun <reified T : Any> T.logDebug(msg: String, throwable: Throwable? = null) {
    if (appLogLevel.ordinaryValue > DEBUG.ordinaryValue) return

    appLogger?.log(DEBUG, logTag(), msg, throwable)
}

inline fun <reified T : Any> T.logError(msg: String, throwable: Throwable? = null) {
    appLogger?.log(ERROR, logTag(), msg, throwable)
}

inline fun <reified T : Any> T.logInfo(msg: String, throwable: Throwable? = null) {
    if (appLogLevel.ordinaryValue > INFO.ordinaryValue) return

    appLogger?.log(INFO, logTag(), msg, throwable)
}

inline fun <reified T : Any> T.logVerbose(msg: String, throwable: Throwable? = null) {
    if (appLogLevel.ordinaryValue > VERBOSE.ordinaryValue) return

    appLogger?.log(VERBOSE, logTag(), msg, throwable)
}

inline fun <reified T : Any> T.logWarning(msg: String, throwable: Throwable? = null) {
    if (appLogLevel.ordinaryValue > WARNING.ordinaryValue) return

    appLogger?.log(WARNING, logTag(), msg, throwable)
}

interface Logger {

    /**
     * Logs a new message.
     *
     * @param level one of [VERBOSE], [DEBUG], [INFO], [WARNING] or [ERROR]
     * @param tag  A logging tag.
     * @param msg  The message to log.
     */
    fun log(level: LogLevel, tag: String, msg: String, throwable: Throwable? = null)
}

var appLogLevel = VERBOSE
var appLogger: Logger? = null

enum class LogLevel(val ordinaryValue: Int) {

    // starting at 2 to match Android's ordinary values from the Log class
    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARNING(5),
    ERROR(6)
}
