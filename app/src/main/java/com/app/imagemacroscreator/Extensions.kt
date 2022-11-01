package com.app.imagemacroscreator

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.*

fun Context.showToast(message: String?){
    message?.let {
        if(message.isNotEmpty()){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}

suspend fun View.convertToBitmap(): String{
    val bitmap: Bitmap = Bitmap.createBitmap(
        measuredWidth,
        measuredHeight,
        Bitmap.Config.ARGB_8888
    )
    val c = Canvas(bitmap)
    draw(c)
    c.drawBitmap(bitmap, 0f, 0f, null)
    val fileName = "IMG_${System.currentTimeMillis()}.png"
    val imageFile = File(context.filesDir, fileName)
    try {
        withContext(Dispatchers.IO) {
            val fOut = FileOutputStream(imageFile)
            bitmap.compress(
                Bitmap.CompressFormat.PNG,
                100,
                fOut
            )
            fOut.flush()
            fOut.close()
        }

    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return fileName
}