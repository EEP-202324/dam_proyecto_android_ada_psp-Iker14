package com.example.proyectoaula2.main2

class CursosRepository {
    private val api = cursosApi.create()

    suspend fun getCursos(): List<CursosAula> {
        return try {
            val response = api.getCursos("/cursos")
            response.map { convertToCursosAula(it) }
        } catch (e: Exception) {
            emptyList()
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
}