package com.example.temp.network.retrofit

import com.example.temp.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance private constructor() {

    companion object {
        @Volatile
        private var instance: Retrofit? = null
        fun getRetrofitInstance() = instance ?: synchronized(this) {
            instance ?: Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }
}