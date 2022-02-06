package de.memorian.av

import de.memorian.av.log.KermitFlykawLogger
import io.github.syex.flykaw.LogConfig
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
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
    LogConfig.setLogger(KermitFlykawLogger())

    single<Navigator> { NavigatorImpl() }
}
