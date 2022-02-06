package de.memorian.av.android

import android.content.Context
import de.memorian.av.android.presentation.navigation.Navigator
import de.memorian.av.android.presentation.navigation.NavigatorImpl
import org.koin.dsl.module

fun App.appModule(context: Context) = module {
    single { context }
    single<Navigator> { NavigatorImpl() }
}