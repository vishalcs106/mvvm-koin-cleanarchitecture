package com.app.imagemacroscreator.di

import com.app.imagemacroscreator.data.repositories.ColorsRepository
import com.app.imagemacroscreator.data.repositories.TemplatesRepository
import com.app.imagemacroscreator.data.usecases.GetColorsUseCaseImpl
import com.app.imagemacroscreator.data.usecases.GetTemplatesUseCaseImpl
import com.app.imagemacroscreator.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
     GetColorsUseCaseImpl(get())
    }

    single {
        GetTemplatesUseCaseImpl(get())
    }

    single {
        ColorsRepository()
    }

    single {
        TemplatesRepository(get())
    }

    viewModel{
        MainViewModel(get(), get())
    }

}