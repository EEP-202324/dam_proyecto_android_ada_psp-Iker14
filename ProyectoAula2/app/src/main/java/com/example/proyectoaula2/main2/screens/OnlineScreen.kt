package com.example.proyectoaula2.main2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.proyectoaula2.main2.CursosAula
import com.example.proyectoaula2.viewmodel.CursosViewModel

@Composable
fun OnlineScreen(navController: NavController, tipo: String) {
    val viewModel: CursosViewModel = viewModel()
    val cursos by viewModel.cursos.collectAsState()
    LaunchedEffect(key1 = tipo) {
        viewModel.cargarCursos(tipo)
    }
    Column(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
        LazyColumn {
            items(cursos) { curso ->
                CursoItem(curso)
            }
        }
        Button(onClick = {  }) {
            Text("Ver detalles")
        }
    }
}

@Composable
fun CursoItem(curso: CursosAula) {
    Card(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(modifier = androidx.compose.ui.Modifier.padding(16.dp)) {
            Text(curso.nombre, style = MaterialTheme.typography.titleMedium)
            Text("Precio: ${curso.precio}")
            Text(curso.descripcion)
        }
    }
}

