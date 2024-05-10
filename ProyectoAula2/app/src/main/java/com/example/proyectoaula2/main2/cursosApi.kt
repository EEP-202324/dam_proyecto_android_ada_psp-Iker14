package com.example.proyectoaula2.main2

import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface cursosApi {
    @GET("/curso")
    suspend fun getCursos(): List<CursosResponse>

    companion object {
        fun create(): cursosApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://localhost:8080")
                .build()
            return retrofit.create(cursosApi::class.java)
        }
    }
}