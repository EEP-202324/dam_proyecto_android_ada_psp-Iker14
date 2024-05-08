package com.example.proyectoaula

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getCursosBydireccion(@Url url: String): Response<CursosResponse>
}