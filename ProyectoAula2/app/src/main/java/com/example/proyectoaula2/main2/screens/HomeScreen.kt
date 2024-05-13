package com.example.proyectoaula2.main2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.proyectoaula2.main2.CursosAula
import com.example.proyectoaula2.main2.CursosRepository
import com.example.proyectoaula2.main2.CursosViewModel

import kotlinx.coroutines.runBlocking

@Composable
fun HomeScreen(navController: NavHostController) {
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
                TextButton(onClick = { navController.navigate("presencial") }) {
                    Text(text = "Cursos presenciales", color = Color.White )
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
                TextButton(onClick = { navController.navigate("onlineScreen/online") }) {
                    Text(text = "Cursos online", color = Color.White )
                }
            }
        }

        Button(onClick = { navController.navigate("formulario") },
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp)) { // Centra el botón y añade margen superior
            Text(text = "+")
        }

//        LazyColumn(state = scrollState) {
//            items(100) {
//                Text("Item $it")
//            }
//        }
    }
}


//@Composable
//fun ShowPresencialCourses() {
//    val courses = remember { mutableStateOf(listOf<CursosAula>()) }
//    LaunchedEffect(Unit) {
//        courses.value = fetchPresencialCoursesFromApi()
//    }
//
//    LazyColumn {
//        items(courses.value) { course ->
//            CourseItem(course)
//        }
//    }
//}

//@Composable
//fun ShowOnlineCursos() {
//    val courses = remember { mutableStateOf(listOf<CursosAula>()) }
//    LaunchedEffect(Unit) {
//        courses.value = fetchOnlineCoursesFromApi()
//    }
//
//    LazyColumn {
//        items(courses.value) { course ->
//            CourseItem(course)
//        }
//    }
//}
//
//@Composable
//fun ShowPresencialCursos() {
//    val courses = remember { mutableStateOf(listOf<CursosAula>()) }
//    LaunchedEffect(Unit) {
//        courses.value = fetchOnlineCoursesFromApi()
//    }
//
//    LazyColumn {
//        items(courses.value) { course ->
//            CourseItem(course)
//        }
//    }
//}
//
//suspend fun fetchPresencialCoursesFromApi(): List<CursosAula> {
//
//    return listOf()
//}
//
//suspend fun fetchOnlineCoursesFromApi(): List<CursosAula> {
//
//    return listOf()
//}

@Composable
fun CourseItem(course: CursosAula) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Nombre del curso: ${course.nombre}")
            Text(text = "Id: ${course.id}")
            Text(text = "Categoria: ${course.categoria}")
            Text(text = "Descripcion: ${course.descripcion}")
            Text(text = "Direccion: ${course.direccion}")
            Text(text = "Precio: ${course.precio}")
        }
    }
}



@Preview
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}