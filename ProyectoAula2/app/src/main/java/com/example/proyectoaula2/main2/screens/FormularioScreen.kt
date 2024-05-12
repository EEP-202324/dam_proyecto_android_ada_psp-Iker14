package com.example.proyectoaula2.main2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            label = { Text("Categoria") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripcion") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = direccion,
            onValueChange = { direccion = it },
            label = { Text("Direccion") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = id,
            onValueChange = { id = it },
            label = { Text("id") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            if (id.isNotBlank() && precio.isNotBlank()) {
                addCourse(categoria, descripcion, direccion, id.toInt(), nombre, precio.toFloat())
            } else {
                println("Los campos id y precio no pueden estar vacíos.")
            }
        },
            modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Añadir curso")
        }
    }
}

fun addCourse(categoria: String, descripcion: String, direccion: String, id: Int, nombre: String, precio: Float) {
    val newCourse = CursosAula(categoria, descripcion, direccion, id, nombre, precio)
    val api = cursosApi.create()
    val response = runBlocking {
        try {
            api.addCourse(newCourse)
        } catch (e: Exception) {
            null
        }
    }
    if (response?.isSuccessful == true) {
        println("El curso se añadió con éxito.")
    } else {
        println("Hubo un error al añadir el curso. Código de error: ${response?.code()}")
    }
}

//@Preview
//@Composable
//fun PreviewFormularioScreen() {
//    val navController = rememberNavController()
//    FormularioScreen(navController = navController)
//}