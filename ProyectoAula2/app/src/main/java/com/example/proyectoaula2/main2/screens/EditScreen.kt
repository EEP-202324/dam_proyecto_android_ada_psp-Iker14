package com.example.proyectoaula2.main2.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.proyectoaula2.main2.CursosAula
import com.example.proyectoaula2.viewmodel.CursosViewModel
import kotlin.random.Random

@Composable
fun EditScreen(navController: NavController, cursoId: String) {
    val viewModel: CursosViewModel = viewModel()
    val cursoIdInt = cursoId.toIntOrNull()

    LaunchedEffect(cursoIdInt) {
        if (cursoIdInt != null) {
            viewModel.getCurso(cursoIdInt)
        }
    }

    val curso by viewModel.cursoState.collectAsState()
    var direccion by remember(curso) { mutableStateOf(curso?.direccion ?: "") }
    var id by remember(curso) { mutableStateOf(curso?.id ?: 0) }
    var nombre by remember(curso) { mutableStateOf(curso?.nombre ?: "") }
    var categoria by remember(curso) { mutableStateOf(curso?.categoria ?: "") }
    var precio by remember(curso) { mutableStateOf(curso?.precio?.toString() ?: "") }
    var descripcion by remember(curso) { mutableStateOf(curso?.descripcion ?: "") }
    if (cursoIdInt != null) {
        Column(modifier = Modifier.padding(16.dp)) {
            TextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            TextField(
                value = categoria,
                onValueChange = { categoria = it },
                label = { Text("Categoría") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            TextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                label = { Text("Descripción") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            TextField(
                value = precio,
                onValueChange = { precio = it },
                label = { Text("Precio") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Online",
                    modifier = Modifier.padding(start = 8.dp)
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    RadioButton(
                        selected = direccion == "online",
                        onClick = { direccion = "online" },
                        colors = RadioButtonDefaults.colors(selectedColor = Color.Black)
                    )
                }
                Text(
                    "Presencial",
                    modifier = Modifier.padding(start = 16.dp)
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    RadioButton(
                        onClick = { direccion = "presencial" },
                        selected = direccion == "presencial",
                        colors = RadioButtonDefaults.colors(selectedColor = Color.Black)
                    )
                }
            }

            Button(
                onClick = {
                    val precioFloat = if (precio.isNotEmpty()) precio.toFloat() else 0f
                    val updatedCourse = CursosAula(categoria, descripcion, direccion, id, nombre, precioFloat)
                    val cursoIdLong = cursoIdInt?.toLong()
                    if (cursoIdLong != null) {
                        viewModel.updateCourse(cursoIdLong, updatedCourse)
                        navController.popBackStack()
                    } else {
                        // Manejar el caso en que cursoIdInt es null
                    }
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