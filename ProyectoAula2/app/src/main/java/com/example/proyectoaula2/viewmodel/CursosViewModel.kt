package com.example.proyectoaula2.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectoaula2.api.ApiService
import com.example.proyectoaula2.api.cursosApi
import com.example.proyectoaula2.main2.CursosAula
import kotlinx.coroutines.flow.MutableStateFlow


import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CursosViewModel() : ViewModel() {
    private val _cursos = MutableStateFlow<List<CursosAula>>(emptyList())
    val cursos : StateFlow<List<CursosAula>> = _cursos.asStateFlow()

    private val curso = MutableStateFlow<CursosAula?>(null)
    val cursoState: StateFlow<CursosAula?> = curso.asStateFlow()

    fun getCurso(id: Int) {
        viewModelScope.launch {
            try {
                val response = cursosApi.retrofitService.obtenerCurso(id)
                if (response.isSuccessful) {
                    curso.value = response.body()
                } else {
                    Log.e(
                        "CursosViewModel",
                        "Failed to get course: ${response.errorBody()?.string()}"
                    )
                }
            } catch (e: Exception) {
                Log.e("CursosViewModel", "Failed to load courses", e)
            }
        }
    }
    fun cargarCursos(tipo: String) {
        viewModelScope.launch {
            try {
                _cursos.value = cursosApi.retrofitService.obtenerCursosPorTipo(tipo).body() ?: emptyList()
            } catch (e: Exception) {
                Log.e("CursosViewModel", "Failed to load courses", e)
                // Aquí puedes manejar los errores como prefieras
            }
        }
    }

    fun createCourse(newCourse: CursosAula) {
        viewModelScope.launch {
            try {
                val response = cursosApi.retrofitService.addCourse(newCourse)
                if (response.isSuccessful) {
                    val addedCourse = response.body()!!
                    val updatedList = _cursos.value.orEmpty().toMutableList().apply {
                        add(addedCourse)
                    }
                    _cursos.value = updatedList
                } else {
                    Log.e(
                        "CursosViewModel",
                        "Failed to add new course: ${response.errorBody()?.string()}"
                    )
                }
            } catch (e: Exception) {
                Log.e("CursosViewModel", "Failed to load courses", e)
            }
        }
    }

    fun deleteCourse(id: Int) {
        viewModelScope.launch {
            try {
                val response = cursosApi.retrofitService.deleteCourse(id)
                if (response.isSuccessful) {
                    _cursos.value = _cursos.value.filter { it.id != id }
                } else {
                    Log.e(
                        "CursosViewModel",
                        "Failed to delete course: ${response.errorBody()?.string()}"
                    )
                }
            } catch (e: Exception) {
                Log.e("CursosViewModel", "Failed to load courses", e)
            }
        }
    }

    fun updateCourse(id: Int, updatedCourse: CursosAula) {
        viewModelScope.launch {
            try {
                val response = cursosApi.retrofitService.updateCourse(id, updatedCourse)
                if (response.isSuccessful && response.body() != null) {
                    val updatedCourse = response.body()!!
                    val updatedList = _cursos.value.orEmpty().toMutableList().apply {
                        val index = indexOfFirst { it.id == updatedCourse.id }
                        if (index != -1) {
                            set(index, updatedCourse)
                        }
                    }
                    _cursos.value = updatedList
                } else {
                    Log.e(
                        "CursosViewModel",
                        "Failed to update course: ${response.errorBody()?.string()}"
                    )
                }
            } catch (e: Exception) {
                Log.e("CursosViewModel", "Failed to load courses", e)
            }
        }
    }
}

//
////class CursosViewModelFactory(private val repository: CursosRepository) : ViewModelProvider.Factory {
////    override fun <T : ViewModel> create(modelClass: Class<T>): T {
////        if (modelClass.isAssignableFrom(CursosViewModel::class.java)) {
////            @Suppress("UNCHECKED_CAST")
////            return CursosViewModel(repository) as T
////        }
////        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
////    }
////}
//
//class CursosViewModel() : ViewModel() {
//    private val _cursos = MutableStateFlow(emptyList<CursosAula>())
//    val cursos : StateFlow<List<CursosAula>> = _cursos.asStateFlow()
//
//
//    fun cargarCursos(tipo: String) {
//        viewModelScope.launch {
//            try {
//                _cursos.value = repository.obtenerCursos(tipo)
//            } catch (e: Exception) {
//                Log.e("CursosViewModel", "Failed to load courses", e)
//                // Aquí puedes manejar los errores como prefieras
//            }
//        }
//    }
//
//    fun updateCursos() {
//        viewModelScope.launch {
//            try {
//                // Creación del objeto 'CursosAula' para añadirlo.
//                val newCourse = CursosAula(
//                    categoria = "categoria",
//                    descripcion = "descripcion",
//                    direccion = "direccion",
//                    id = "id",
//                    nombre = "nombre",
//                    precio = 0.0f
//                )
//
//                // Llamada al repositorio para añadir el curso.
//                val response = repository.addCourse(newCourse)
//
//                // Comprobación de la respuesta exitosa y que el cuerpo no esté vacío.
//                if (response.isSuccessful && response.body() != null) {
//                    // Recuperación del curso recién añadido desde la respuesta.
//                    val addedCourse = response.body()!!
//
//                    // Actualización de la lista de cursos en LiveData.
//                    val updatedList = _cursos.value.orEmpty().toMutableList().apply {
//                        add(addedCourse)
//                    }
//                    _cursos.value = updatedList
//                } else {
//                    // Registro de error si la API falla en devolver una respuesta exitosa.
//                    Log.e(
//                        "CursosViewModel",
//                        "Failed to add new course: ${response.errorBody()?.string()}"
//                    )
//                }
//            } catch (e: Exception) {
//                // Registro de cualquier excepción lanzada durante el proceso.
//                Log.e("CursosViewModel", "Failed to load courses", e)
//            }
//        }
//    }
//}





