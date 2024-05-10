package com.example.proyectoaula2.main2

data class MainState(
    val cursos: List<CursosResponseItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
