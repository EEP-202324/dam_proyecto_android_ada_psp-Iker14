package com.example.proyectoaula2.network

import com.example.proyectoaula2.main2.cursosApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private const val BASE_URL = "http://10.0.2.2:8080/"

    val api: cursosApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(cursosApi::class.java)
    }
}
