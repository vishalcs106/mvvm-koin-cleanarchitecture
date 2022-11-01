package com.app.imagemacroscreator.domain.usecases

import android.graphics.Bitmap

interface IGetTemplatesUseCase {
    suspend fun getTemplate(): Bitmap?
}