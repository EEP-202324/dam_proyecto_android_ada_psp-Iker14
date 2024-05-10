package com.example.proyectoaula

import com.google.gson.annotations.SerializedName

data class Curso(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val descripcion: String,
    val categoria: String,
    val direccion: String
)

data class CursosResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val datos: List<String>
)