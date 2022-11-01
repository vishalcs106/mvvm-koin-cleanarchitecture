package com.app.imagemacroscreator.data.usecases

import com.app.imagemacroscreator.data.repositories.ColorsRepository
import com.app.imagemacroscreator.domain.usecases.IGetColorsUseCase

class GetColorsUseCaseImpl(private val colorsRepository: ColorsRepository): IGetColorsUseCase {
    override fun getColor(): Int {
        return colorsRepository.fetchRandomColor()
    }
}