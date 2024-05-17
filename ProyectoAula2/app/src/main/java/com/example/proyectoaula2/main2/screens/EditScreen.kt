package com.example.proyectoaula2.main2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.proyectoaula2.main2.CursosAula
import com.example.proyectoaula2.viewmodel.CursosViewModel
import kotlin.random.Random

@Composable
fun EditScreen(navController: NavController, cursoId: String) {
    val viewModel: CursosViewModel = viewModel()
    val curso by viewModel.cursoState.collectAsState()
    var direccion by remember { mutableStateOf(curso?.direccion ?: "") }
    var id by remember { mutableStateOf(Random.nextInt()) }
    var nombre by remember { mutableStateOf(curso?.nombre ?: "") }
    var categoria by remember { mutableStateOf(curso?.categoria ?: "") }
    var precio by remember { mutableStateOf(curso?.precio ?: 0.0) }
    var descripcion by remember { mutableStateOf(curso?.descripcion ?: "") }

    val cursoIdInt = cursoId.toIntOrNull()
    if (cursoIdInt != null) {
        Column {
            TextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") }
            )
            TextField(
                value = categoria,
                onValueChange = { categoria = it },
                label = { Text("Categoría") }
            )
            TextField(
                value = precio.toString(),
                onValueChange = { precio = (it.toFloatOrNull() ?: 0.0f) as Any },
                label = { Text("Precio") }
            )
            TextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                label = { Text("Descripción") }
            )
            Button(
                onClick = {
                    val updatedCourse = CursosAula(categoria, descripcion, direccion, id, nombre, precio.toFloat())
                    viewModel.updateCourse(cursoIdInt, updatedCourse)
                    navController.popBackStack()
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Editar curso")
            }
        }
    } else {
        // Manejar el caso en que cursoId no puede ser convertido a Int
    }
}