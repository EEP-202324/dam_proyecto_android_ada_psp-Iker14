package com.example.proyectoaula2.main2.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectoaula2.main2.CursosAula
import com.example.proyectoaula2.viewmodel.CursosViewModel


@Composable
fun PresencialScreen(navController: NavController, tipo: String) {
    val viewModel: CursosViewModel = viewModel()
    val cursos by viewModel.cursos.collectAsState()

    LaunchedEffect(key1 = tipo) {
        viewModel.cargarCursos(tipo)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(cursos) { curso ->
                Curso2Item(curso)
            }

        }
        Button(onClick = { navController.navigate("home") }) {
            Text("Salir")
        }
    }
}

@Composable
fun Curso2Item(curso: CursosAula, viewModel: CursosViewModel = viewModel(), navController: NavController = rememberNavController()) {
    var detallesVisibles by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { detallesVisibles = !detallesVisibles },
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Nombre del curso en grande y en negrita
            Row {
                Text(
                    curso.nombre,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.width(16.dp))

                // Si los detalles están visibles, muestra el texto "Ocultar detalles"
                if (detallesVisibles) {
                    Text("Ocultar detalles")
                } else {
                    // Si los detalles no están visibles, muestra el texto "Ver detalles"
                    Text("Ver detalles")
                }
            }
//            Text(
//                curso.nombre,
//                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
//            )

            if (detallesVisibles) {
                Text(text = curso.categoria, style = MaterialTheme.typography.bodyMedium)
                Text("Precio: ${curso.precio}")
                Text(curso.descripcion)
                IconButton(onClick = { navController.navigate("edit/${curso.id}") }) {
                    Icon(Icons.Filled.Edit, contentDescription = "Editar curso")
                }
                IconButton(onClick = { viewModel.deleteCourse(curso.id) }) {
                    Icon(Icons.Filled.Delete, contentDescription = "Eliminar curso")

                }

            }


        }
    }
}

