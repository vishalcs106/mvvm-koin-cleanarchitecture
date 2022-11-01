package com.app.imagemacroscreator.presentation

import android.app.Application
import com.app.imagemacroscreator.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class ImageMacrosCreatorApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
           androidContext(this@ImageMacrosCreatorApp)
            modules(appModule)
        }
    }
}