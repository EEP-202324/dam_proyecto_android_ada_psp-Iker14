package com.example.proyectoaula2.main2

import android.util.Log
import com.example.proyectoaula2.main2.cursosApi.Companion.create
import com.example.proyectoaula2.network.RetrofitInstance
import retrofit2.Response

class CursosRepository(private val apiService: cursosApi) {
    suspend fun obtenerCursos(direccion: String): List<CursosAula> {
        val response = apiService.obtenerCursosPorTipo(direccion)
        if (response.isSuccessful && response.body() != null) {
            return response.body()!!
        } else {
            Log.e("CursosRepository", "Error fetching courses: ${response.message()}")
            throw Exception("Error fetching courses: ${response.message()}")
        }
    }

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
        return apiService.obtenerCursosPorTipo(direccion)
    }

//    suspend fun getPresencialCursos(): List<CursosAula> {
//        try {
//            val response = cursosApi.obtenerCursosPresenciales()
//            if (response.isSuccessful) {
//                return response.body() ?: emptyList()
//            } else {
//                throw Exception("Error from API: ${response.errorBody()?.string()}")
//            }
//        } catch (e: Exception) {
//            throw Exception("Error accessing the API", e)
//        }
//    }
//    }
}