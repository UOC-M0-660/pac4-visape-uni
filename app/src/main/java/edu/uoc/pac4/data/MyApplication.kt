package edu.uoc.pac4.data

import android.app.Application
import edu.uoc.pac4.data.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //Start Koin
        startKoin {
            printLogger()
            modules(dataModule)
            androidContext(this@MyApplication)
        }
    }
}