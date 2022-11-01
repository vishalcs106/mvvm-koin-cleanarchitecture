package com.app.imagemacroscreator.data.usecases

import android.app.Application
import android.graphics.Bitmap
import com.app.imagemacroscreator.data.repositories.TemplatesRepository
import com.app.imagemacroscreator.domain.usecases.IGetTemplatesUseCase
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetTemplatesUseCaseImpl(private val templatesRepository: TemplatesRepository): IGetTemplatesUseCase {
    override suspend fun getTemplate(): Bitmap? {
        return templatesRepository.getTemplatesFromList()
    }
}