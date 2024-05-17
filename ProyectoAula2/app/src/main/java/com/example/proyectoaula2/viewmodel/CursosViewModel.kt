package com.example.proyectoaula2.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectoaula2.api.ApiService
import com.example.proyectoaula2.api.cursosApi
import com.example.proyectoaula2.main2.CursosAula
import com.google.gson.JsonSyntaxException
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

    fun updateCourse(id: Long, updatedCourse: CursosAula) {
        viewModelScope.launch {
            try {
                val response = cursosApi.retrofitService.updateCourse(id, updatedCourse)
                if (response.isSuccessful && response.body() != null) {
                    val updatedCourse = response.body()!!
                    Log.d("CursosViewModel", "Curso actualizado: $updatedCourse")
                } else {
                    Log.e("CursosViewModel", "Failed to update course: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("CursosViewModel", "Error updating course", e)
            }
        }
    }

}

