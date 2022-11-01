package com.app.imagemacroscreator.data.models

import android.graphics.Bitmap
import com.app.imagemacroscreator.domain.models.IImageMacroModel

data class ImageMacrosModel(
    override var text: String?,
    override var backgroundColor: Int?,
    override var image: Bitmap?
) : IImageMacroModel