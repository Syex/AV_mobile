package de.memorian.av.log

import co.touchlab.kermit.Severity
import co.touchlab.kermit.Logger as KermitLogger

class DefaultLogger : Logger {

    private val kermitLogger = KermitLogger

    override fun log(level: LogLevel, tag: String, msg: String, throwable: Throwable?) {
        kermitLogger.log(
            severity = level.toKermitSeverity(),
            tag = tag,
            throwable = throwable,
            message = msg
        )
    }

    private fun LogLevel.toKermitSeverity() = when (this) {
        LogLevel.VERBOSE -> Severity.Verbose
        LogLevel.DEBUG -> Severity.Debug
        LogLevel.INFO -> Severity.Info
        LogLevel.WARNING -> Severity.Warn
        LogLevel.ERROR -> Severity.Error
    }
}