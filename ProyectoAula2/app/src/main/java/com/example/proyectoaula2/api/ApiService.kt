package com.example.proyectoaula2.api

import com.example.proyectoaula2.main2.CursosAula
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("curso/query-direccion")
    suspend fun obtenerCursosPorTipo(@Query("direccion") direccion: String): Response<List<CursosAula>>

    @GET("curso/{id}")
    suspend fun obtenerCurso(@Query("id") id: Int): Response<CursosAula>

    @POST("curso")
    suspend fun addCourse(@Body newCourse: CursosAula): Response<CursosAula>

    @DELETE("curso/{id}")
    suspend fun deleteCourse(@Path("id") id: Int): Response<Unit>

    @PUT("curso/{id}")
    suspend fun updateCourse(@Path("id") id: Long, @Body updatedCourse: CursosAula): Response<CursosAula>
}