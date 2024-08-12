// WriterApp.kt
package com.example.writerapp

import android.app.Application
import com.example.writerapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WriterApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WriterApp)
            modules(appModule)
        }
    }
}
