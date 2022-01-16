package de.memorian.av

import co.touchlab.kermit.Logger
import de.memorian.av.log.DefaultLogger
import de.memorian.av.log.appLogger
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

fun initKoin(appModule: Module): KoinApplication {
    val koinApplication = startKoin {
        modules(
            appModule,
            coreModule
        )
    }

    return koinApplication
}

private val coreModule = module {
    appLogger = DefaultLogger()
}

inline fun <reified T> KoinComponent.injectLogger(): Lazy<Logger> =
    inject { parametersOf(T::class.simpleName) }