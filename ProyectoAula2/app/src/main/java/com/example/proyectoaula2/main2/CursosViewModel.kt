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
    private val _cursosPresenciales = MutableLiveData<List<CursosAula>>()
    val cursosPresenciales: LiveData<List<CursosAula>> = _cursosPresenciales
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchCursosPresenciales(direccion: String) {
        viewModelScope.launch {
            try {
                val response = repository.obtenerCursosPresenciales(direccion)
                if (response.isSuccessful && response.body() != null) {
                    _cursosPresenciales.postValue(response.body())
                } else {
                    _error.postValue("Error loading courses: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                _error.postValue("Network error: ${e.message}")
            }
        }
    }
}





