package com.example.proyectoaula2.main2

import android.util.Log
import com.example.proyectoaula2.main2.cursosApi.Companion.create
import com.example.proyectoaula2.network.RetrofitInstance
import retrofit2.Response

class CursosRepository {

    private val api: CursosApi by lazy {
        create()
    }

    private fun create(): CursosApi {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")  // Cambiar según sea necesario para el entorno de desarrollo o producción
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CursosApi::class.java)
    }

    suspend fun obtenerCursosPresenciales(direccion: String): Response<List<CursosAula>> {
        return api.obtenerCursosPresenciales(direccion)
    }

//    private val api = cursosApi.create()
//
//    suspend fun getCursos(): List<CursosAula> {
//        return try {
//            val response = api.getCursos("/curso/")
//            response.map { convertToCursosAula(it) }
//        } catch (e: Exception) {
//            emptyList()
//        }
//    }




    private fun convertToCursosAula(data: CursosResponse) : CursosAula {
        return CursosAula(
            categoria = data.categoria,
            descripcion = data.descripcion,
            direccion = data.direccion,
            id = data.id,
            nombre = data.nombre,
            precio = data.precio
        )
    }

    suspend fun obtenerCursosPresenciales(direccion: String): Response<List<CursosAula>> {
        val api = create()
        return api.obtenerCursosPresenciales(direccion)
    }


    suspend fun getPresencialCursos(): List<CursosAula> {
        try {
            val response = cursosApi.obtenerCursosPresenciales()
            if (response.isSuccessful) {
                return response.body() ?: emptyList()
            } else {
                throw Exception("Error from API: ${response.errorBody()?.string()}")
            }
        } catch (e: Exception) {
            throw Exception("Error accessing the API", e)
        }
    }
    }
}