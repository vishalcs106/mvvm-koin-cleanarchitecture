package com.app.imagemacroscreator.data.repositories

import com.app.imagemacroscreator.R
import com.app.imagemacroscreator.domain.repositories.IColorsRepository
import kotlin.random.Random

class ColorsRepository(): IColorsRepository {

    override fun fetchRandomColor(): Int {
        return colorsList[Random.nextInt(0, colorsList.size)]
    }

    companion object{
        private val colorsList = listOf(R.color.red_500,R.color.pink_500, R.color.purple_200,
            R.color.deep_purple_500, R.color.blue_500, R.color.light_blue_500, R.color.cyan_500,
            R.color.teal_500, R.color.orange_500, R.color.deep_orange_500, R.color.brown_500,
            R.color.blue_grey_500, R.color.indigo_500, R.color.lime_500, R.color.green_500,
            R.color.light_green_500, R.color.yellow_500, R.color.amber_500,R.color.grey_500)
    }



}