package com.example.proyectoaula2.main2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.ui.res.painterResource
import com.example.proyectoaula2.R

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.TopAppBar

import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        AppBarWithLogo()
    }
//    val scrollState = rememberLazyListState()
//    val coroutineScope = rememberCoroutineScope()
//    rememberCoroutineScope()
    rememberLazyListState()
    rememberCoroutineScope()

    Column (
        modifier = Modifier.fillMaxSize().padding(top = 300.dp), // Mueve todos los elementos hacia abajo
        verticalArrangement = Arrangement.Center

    ) {
        Column(modifier = Modifier.weight(1f)) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center ,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xFF000080))
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable { navController.navigate("Cursos presenciales") }
            ) {
                TextButton(onClick = { navController.navigate("online") }) {
                    Text(text = "Cursos Online", color = Color.White )
                }
            }

            Spacer(modifier = Modifier.height(50.dp))

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center ,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xFF000080))
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { navController.navigate("Cursos online") }
            ) {
                TextButton(onClick = { navController.navigate("presencial") }) {
                    Text(text = "Cursos Presenciales", color = Color.White )
                }
            }
        }

        Button(onClick = { navController.navigate("formulario") },
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp)) { // Centra el botón y añade margen superior
            Text(text = "+")
        }


    }
}

@Composable
fun AppBarWithLogo() {
    TopAppBar(
        backgroundColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        contentPadding = PaddingValues(horizontal = 25.dp),
        elevation = 0.dp,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.mipmap.logo_app_foreground),
                contentDescription = "Logo de la App",
                modifier = Modifier
                    .width(800.dp)
                    .height(800.dp)
            )
        }
    }
}




//@Composable
//fun CourseItem(course: CursosAula) {
//    Card(modifier = Modifier
//        .fillMaxWidth()
//        .padding(8.dp)) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(text = "Nombre del curso: ${course.nombre}")
//            Text(text = "Id: ${course.id}")
//            Text(text = "Categoria: ${course.categoria}")
//            Text(text = "Descripcion: ${course.descripcion}")
//            Text(text = "Direccion: ${course.direccion}")
//            Text(text = "Precio: ${course.precio}")
//        }
//    }
//}



@Preview
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}