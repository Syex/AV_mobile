package de.memorian.av.log

import co.touchlab.kermit.Severity
import io.github.syex.flykaw.LogLevel
import io.github.syex.flykaw.Logger
import co.touchlab.kermit.Logger as KermitLogger

class KermitFlykawLogger : Logger {

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