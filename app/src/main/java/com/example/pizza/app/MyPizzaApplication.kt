package com.example.pizza.app

import android.app.Application
import com.example.pizza.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MyPizzaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyPizzaApplication)
            modules(
                appModule,
            )
        }
    }
}