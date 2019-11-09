
package kz.ticker.android
import android.app.Application


import kz.ticker.android.di.archModule
import kz.ticker.android.di.netModule
import kz.ticker.android.di.utilModule
import org.koin.android.ext.android.startKoin


open  class App : Application(){


    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(netModule, archModule, utilModule))
    }

}
