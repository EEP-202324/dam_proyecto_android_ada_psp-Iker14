package com.example.proyectoaula2.main2

class CursosRepository {
    private val api = cursosApi.create()

    suspend fun getCursos(): List<CursosAula> {
        return try {
            val response = api.getCursos("/curso")
            response.map { convertToCursosAula(it) }
        } catch (e: Exception) {
            emptyList()
        }
    }

//    suspend fun getPresencialCursos(): List<CursosAula> {
//        // Ejemplo de llamada a un método genérico que obtiene todos los cursos y luego filtra por tipo
//        val todosLosCursos = cursosApi.getPresencialCursos()
//        return todosLosCursos.filter { it.tipo == "Presencial" } // Asumiendo que hay un campo 'tipo'
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
}