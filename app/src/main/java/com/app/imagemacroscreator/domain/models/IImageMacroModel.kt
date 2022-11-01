package com.app.imagemacroscreator.domain.models

import android.graphics.Bitmap

interface IImageMacroModel {
    var text: String?
    var backgroundColor: Int?
    var image: Bitmap?
}