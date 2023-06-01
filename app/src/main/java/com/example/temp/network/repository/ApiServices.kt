package com.example.temp.network.repository

import com.example.temp.model.ApiModelItem
import retrofit2.http.GET

interface ApiServices {
    @GET("/photos")
    suspend fun getPhotos(): List<ApiModelItem>
}
