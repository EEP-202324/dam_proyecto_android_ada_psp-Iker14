package com.example.proyectoaula2.main2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.proyectoaula2.main2.CursosAula
import com.example.proyectoaula2.main2.CursosViewModel
import java.lang.reflect.Modifier

@Composable
fun OnlineScreen(navController: NavController) {
    val viewModel: CursosViewModel = viewModel()
    val cursos = remember { mutableStateOf(listOf<CursosAula>()) }

//    LaunchedEffect(key1 = viewModel) {
//        cursos.value = viewModel.fetchOnlineCursosFromApi()
//    }

    LazyColumn {
        items(cursos.value) { curso ->
            Card {
                Column {
                    Text(text = curso.nombre)
                    Text(text = curso.descripcion)
                    // Agrega más campos según sea necesario
                }
            }
        }
    }
}