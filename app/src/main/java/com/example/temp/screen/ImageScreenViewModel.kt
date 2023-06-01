package com.example.temp.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.temp.model.ApiModelItem
import com.example.temp.network.repository.ApiImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ImageScreenViewModel : ViewModel() {
    private val apiImpl = ApiImpl()
    private val _photos = MutableStateFlow<List<ApiModelItem>>(emptyList())
    val photos = _photos.asStateFlow()
    fun getPhotos() {
        viewModelScope.launch {
            _photos.value = apiImpl.getPhotos()
        }
    }
}