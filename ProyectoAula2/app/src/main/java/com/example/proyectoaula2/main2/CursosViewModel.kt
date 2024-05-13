package com.example.proyectoaula2.main2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch


class CursosViewModelFactory(private val repository: CursosRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CursosViewModel::class.java)) {
            return CursosViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class CursosViewModel(private val repository: CursosRepository) : ViewModel() {
    private val _cursos = MutableLiveData<List<CursosAula>>()
    val cursos: LiveData<List<CursosAula>> = _cursos

    fun cargarCursos(tipo: String) {
        viewModelScope.launch {
            try {
                _cursos.value = repository.obtenerCursos(tipo)
            } catch (e: Exception) {
                Log.e("CursosViewModel", "Failed to load courses", e)
                // Aquí puedes manejar los errores como prefieras
            }
        }
    }
}





