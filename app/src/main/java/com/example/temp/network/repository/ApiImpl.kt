package com.example.temp.network.repository

import android.util.Log
import com.example.temp.model.ApiModelItem
import com.example.temp.network.retrofit.RetrofitInstance

class ApiImpl() : ApiServices {
    private val retrofit = RetrofitInstance.getRetrofitInstance().create(ApiServices::class.java)
    private var apiModel = listOf<ApiModelItem>()
    override suspend fun getPhotos(): List<ApiModelItem> {
        try {
            apiModel= retrofit.getPhotos()
        } catch (exception: Exception) {
            Log.e("Exception", exception.toString())
        }
        return apiModel
    }

}