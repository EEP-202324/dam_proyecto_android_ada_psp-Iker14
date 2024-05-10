package com.example.proyectoaula2.main2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CursosViewModel(private val repository: CursosRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            val cursos = repository.getCursos()
            // Handle the list of courses
        }
    }
}