package com.app.imagemacroscreator.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.imagemacroscreator.R
import com.app.imagemacroscreator.data.models.ImageMacrosModel
import com.app.imagemacroscreator.data.usecases.GetColorsUseCaseImpl
import com.app.imagemacroscreator.data.usecases.GetTemplatesUseCaseImpl
import com.app.imagemacroscreator.domain.models.IImageMacroModel
import com.app.imagemacroscreator.utils.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel constructor(
    private val getColorsUseCase: GetColorsUseCaseImpl,
    private val templatesUseCase: GetTemplatesUseCaseImpl,
) : ViewModel() {

    private val _dataState = MutableLiveData<DataState<IImageMacroModel>>()
    val dataState = _dataState as LiveData<DataState<IImageMacroModel>>

    private val imageMacrosModel = ImageMacrosModel("", R.color.black, null)

    fun getColor() {
        viewModelScope.launch(Dispatchers.IO) {
            _dataState.postValue(DataState.Loading)
            imageMacrosModel.backgroundColor = getColorsUseCase.getColor()
            postData()
        }
    }

    private suspend fun postData(){
        withContext(Dispatchers.Main){
            _dataState.postValue(DataState.Success(imageMacrosModel))
        }
    }

    fun getTemplate(){
        viewModelScope.launch {
            _dataState.postValue(DataState.Loading)
            val bitmap = templatesUseCase.getTemplate()
            if(bitmap == null){
                _dataState.postValue(DataState.Error(Exception("Unable to load image")))
            } else{
                imageMacrosModel.image = bitmap
                postData()
            }
        }
    }

    fun addText(bottomText: String) {
        imageMacrosModel.text = bottomText
        _dataState.postValue(DataState.Success(imageMacrosModel))
    }

}