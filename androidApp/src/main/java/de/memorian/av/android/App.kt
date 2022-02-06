package de.memorian.av.android

import android.app.Application
import de.memorian.av.initKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(appModule(this))
    }
}