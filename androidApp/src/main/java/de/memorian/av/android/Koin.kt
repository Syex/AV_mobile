package de.memorian.av.android

import android.content.Context
import de.memorian.av.presentation.scannedproducts.ScannedProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun App.appModule(context: Context) = module {
    single { context }

    viewModel { ScannedProductsViewModel(get()) }
}