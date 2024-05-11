package com.example.proyectoaula2.main2

import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url

interface cursosApi {
    @GET
    suspend fun getCursos(@Url url: String): List<CursosResponse>

    companion object {
        fun create(): cursosApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://localhost:8080")
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
        val response = api.getCursos("/curso/query-direction?direction=in-person")
        return response.map { CursosMapper.convertToCursosAula(it) }
    }

    suspend fun fetchOnlineCursosFromApi(): List<CursosAula> {
        val api = cursosApi.create()
        val response = api.getCursos("/curso/query-direction?direction=online")
        return response.map { CursosMapper.convertToCursosAula(it) }
    }
}
