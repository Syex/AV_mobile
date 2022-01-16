package de.memorian.av.android

import android.app.Application
import android.content.Context
import de.memorian.av.initKoin
import de.memorian.av.log.logInfo
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(
            module {
                single<Context> { this@App }
            }
        )

        logInfo("Hello TEST message!", Exception())
    }
}