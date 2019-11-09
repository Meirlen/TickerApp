package kz.ticker.android.di


import kz.ticker.android.router.MainRouter

import org.koin.dsl.module.module

val utilModule = module {
    single {
        MainRouter()
    }
}