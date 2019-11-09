package kz.ticker.android.di


import kz.ticker.android.router.MainRouter
import kz.ticker.android.utils.NetworkHandler

import org.koin.dsl.module.module

val utilModule = module {
    single {
        MainRouter()
    }
    single {
        NetworkHandler(get())
    }
}