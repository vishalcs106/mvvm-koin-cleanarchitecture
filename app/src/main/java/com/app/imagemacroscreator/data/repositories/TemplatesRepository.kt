package com.app.imagemacroscreator.data.repositories

import android.app.Application
import android.graphics.Bitmap
import com.app.imagemacroscreator.domain.repositories.ITemplatesRepository
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.random.Random

class TemplatesRepository(private val application: Application): ITemplatesRepository {

    override suspend fun getTemplatesFromList(): Bitmap? {
        try {
            return withContext(Dispatchers.IO) {
                Glide
                    .with(application)
                    .asBitmap()
                    .load(urlList[Random.nextInt(0, urlList.size)])
                    .submit()
                    .get()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    companion object{
        private val urlList = listOf<String>("https://imgflip.com/s/meme/Disaster-Girl.jpg",
            "https://imgflip.com/s/meme/Distracted-Boyfriend.jpg",
        "https://imgflip.com/memetemplate/One-Does-Not-Simply",
        "https://imgflip.com/s/meme/Grandma-Finds-The-Internet.jpg",
        "https://imgflip.com/s/meme/X-X-Everywhere.jpg",
            "https://imgflip.com/s/meme/Leonardo-Dicaprio-Cheers.jpg",
        "https://imgflip.com/s/meme/Roll-Safe-Think-About-It.jpg")
    }

}