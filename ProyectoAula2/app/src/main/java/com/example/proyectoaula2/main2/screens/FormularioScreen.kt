package com.example.proyectoaula2.main2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.proyectoaula2.main2.CursosAula
import com.example.proyectoaula2.viewmodel.CursosViewModel

@Composable
fun FormularioScreen(navController: NavController) {
    val viewModel: CursosViewModel = viewModel()
    val context = LocalContext.current
    var categoria by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var id by remember { mutableIntStateOf(0) }
    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }

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
            value = direccion,
            onValueChange = { direccion = it },
            label = { Text("Dirección: (online/presencial)") },
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

        Button(
            onClick = {

                val newCourse =
                    CursosAula(categoria, descripcion, direccion, id, nombre, precio.toFloat())
                viewModel.createCourse(newCourse)
                navController.popBackStack()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Añadir curso")
        }
    }
}

//fun addCourse(categoria: String, descripcion: String, direccion: String, id: Int, nombre: String, precio: Float) {
//    val newCourse = CursosAula(categoria, descripcion, direccion, id, nombre, precio)
//    val api = cursosApi.create()
//    val response = runBlocking {
//        try {
//            api.addCourse(newCourse)
//        } catch (e: Exception) {
//            null
//        }
//    }
//    if (response?.isSuccessful == true) {
//        println("El curso se añadió con éxito.")
//    } else {
//        println("Hubo un error al añadir el curso. Código de error: ${response?.code()}")
//    }
//}

//@Preview
//@Composable
//fun PreviewFormularioScreen() {
//    val navController = rememberNavController()
//    FormularioScreen(navController = navController)
//}