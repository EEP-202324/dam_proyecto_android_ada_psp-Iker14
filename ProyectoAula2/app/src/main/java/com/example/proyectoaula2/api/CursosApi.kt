package com.example.proyectoaula2.api

import com.example.proyectoaula2.main2.CursosAula
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

object cursosApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}





