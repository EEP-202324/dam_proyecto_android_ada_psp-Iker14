//package com.example.proyectoaula2.main2.screens
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import com.example.proyectoaula2.viewmodel.CursosViewModel
//
//@Composable
//fun EditScreen(cursoId: String, navController: NavController) {
//    val viewModel: CursosViewModel = viewModel()
//    val curso by viewModel.getCurso(cursoId).collectAsState(initial = null)
//
//    var nombre by remember { mutableStateOf(curso?.nombre ?: "") }
//    var descripcion by remember { mutableStateOf(curso?.descripcion ?: "") }
//    var precio by remember { mutableStateOf(curso?.precio ?: 0.0) }
//
//    Column {
//        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
//        TextField(value = descripcion, onValueChange = { descripcion = it }, label = { Text("Descripción") })
//        TextField(value = precio.toString(), onValueChange = { precio = it.toDoubleOrNull() ?: 0.0 }, label = { Text("Precio") })
//
//        Button(onClick = {
//            viewModel.updateCurso(cursoId, nombre, descripcion, precio)
//            navController.popBackStack()
//        }) {
//            Text("Guardar")
//        }
//    }
//}