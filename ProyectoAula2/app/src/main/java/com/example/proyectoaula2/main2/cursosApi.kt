package com.example.proyectoaula2.main2

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface cursosApi {
    @GET
    suspend fun getCursos(@Url url: String): List<CursosResponse>

    @GET("/curso/query-direccion?direction=presencial")
    suspend fun getPresencialCursos(): List<CursosResponse>


    @POST("curso")
    suspend fun addCourse(@Body newCourse: CursosAula): Response<CursosAula>

    companion object {
        fun create(): cursosApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:8080/curso")
                .build()
            return retrofit.create(cursosApi::class.java)
        }
    }

    object CursosMapper {
        fun convertToCursosAula(data: CursosResponse) : CursosAula {
            return CursosAula(
                categoria = data.categoria,
                descripcion = data.descripcion,
                direccion = data.direccion,
                id = data.id,
                nombre = data.nombre,
                precio = data.precio
            )
        }
    }

    suspend fun fetchPresencialCursosFromApi(): List<CursosAula> {
        val api = cursosApi.create()
        val response = api.getCursos("/curso/query-direccion?direction=presencial")
        return response.map { CursosMapper.convertToCursosAula(it) }
    }

    suspend fun fetchOnlineCursosFromApi(): List<CursosAula> {
        val api = cursosApi.create()
        val response = api.getCursos("/curso/query-direccion?direction=online")
        return response.map { CursosMapper.convertToCursosAula(it) }
    }
}
