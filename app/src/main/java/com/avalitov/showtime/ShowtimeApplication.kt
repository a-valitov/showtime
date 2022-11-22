package com.avalitov.showtime

import android.app.Application
import android.content.Context
import com.avalitov.showtime.main.di.MainDependencies.mainModule
import com.avalitov.showtime.pages.populars.di.popularsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShowtimeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Dependency injection starting point
        startKoin {
            modules(
                mainModule,
                popularsModule
            )
            androidContext(this@ShowtimeApplication)
        }

        appContext = applicationContext
    }

    companion object {
        lateinit var appContext: Context
            private set
    }
}