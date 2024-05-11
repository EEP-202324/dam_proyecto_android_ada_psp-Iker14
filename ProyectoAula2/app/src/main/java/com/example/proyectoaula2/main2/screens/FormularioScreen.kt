package com.example.proyectoaula2.main2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectoaula2.main2.CursosAula
import com.example.proyectoaula2.main2.cursosApi
import kotlinx.coroutines.runBlocking


@Composable
fun FormularioScreen(navController: NavController) {
    var categoria by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }

    Column {
        TextField(
            value = categoria,
            onValueChange = { categoria = it },
            label = { Text("Categoria") }
        )
        TextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripcion") }
        )
        TextField(
            value = direccion,
            onValueChange = { direccion = it },
            label = { Text("Direccion") }
        )
        TextField(
            value = id,
            onValueChange = { id = it },
            label = { Text("id") }
        )
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )
        TextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio") }
        )
        Button(onClick = { addCourse(categoria, descripcion, direccion, id.toInt(), nombre, precio.toFloat()) }) {
            Text("Añadir curso")
        }
    }
}

fun addCourse(categoria: String, descripcion: String, direccion: String, id: Int, nombre: String, precio: Float) {
    val newCourse = CursosAula(categoria, descripcion, direccion, id, nombre, precio)
    val api = cursosApi.create()
    val response = runBlocking { api.addCourse(newCourse) }
    if (response.isSuccessful) {
        // Handle successful response
    } else {
        // Handle error
    }
}

@Preview
@Composable
fun PreviewFormularioScreen() {
    val navController = rememberNavController()
    FormularioScreen(navController = navController)
}