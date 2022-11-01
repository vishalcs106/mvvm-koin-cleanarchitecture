package com.app.imagemacroscreator.domain.repositories

import android.app.Application
import android.graphics.Bitmap

interface ITemplatesRepository {
    suspend fun getTemplatesFromList(): Bitmap?
}