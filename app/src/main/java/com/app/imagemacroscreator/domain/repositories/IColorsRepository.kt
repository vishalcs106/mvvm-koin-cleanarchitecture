package com.app.imagemacroscreator.domain.repositories

interface IColorsRepository {
    fun fetchRandomColor(): Int
}