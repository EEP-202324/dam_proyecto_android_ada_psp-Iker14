package com.example.proyectoaula2.main2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CursosViewModel(private val repository: CursosRepository) : ViewModel() {
    private val _cursosPresenciales = MutableLiveData<List<CursosAula>>()
    val cursosPresenciales: LiveData<List<CursosAula>> = _cursosPresenciales

//    init {
//        viewModelScope.launch {
//            _cursosPresenciales.value = fetchPresencialCursosFromApi()
//        }
//    }

//    private suspend fun fetchPresencialCursosFromApi(): List<CursosAula> {
//        return repository.getPresencialCursos()
//    }
}

