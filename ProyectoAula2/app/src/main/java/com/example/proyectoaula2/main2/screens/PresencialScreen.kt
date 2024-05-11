package com.example.proyectoaula2.main2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectoaula2.main2.CursosAula
import com.example.proyectoaula2.main2.CursosViewModel

//@Composable
//fun PresencialScreen(navController: NavController, viewModel: CursosViewModel = viewModel()) {
//    val cursosPresenciales = viewModel.cursosPresenciales.observeAsState(initial = emptyList())
//
//    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
//        items(cursosPresenciales.value) { curso ->
//            CursoItem(curso)
//        }
//    }
//}

//@Composable
//fun CursoItem(curso: CursosAula) {
//    Card(modifier = Modifier.fillMaxWidth().padding(8.dp), elevation = 4.dp) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(text = curso.nombre, style = MaterialTheme.typography.h6)
//            Text(text = curso.descripcion, style = MaterialTheme.typography.body2)
//        }
//    }
//}

@Composable
fun PresencialScreen(navController: NavController) {



}
