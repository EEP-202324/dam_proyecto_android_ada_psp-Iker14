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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectoaula2.main2.CursosAula
import com.example.proyectoaula2.main2.CursosRepository
import kotlinx.coroutines.runBlocking

@Composable
fun HomeScreen() {
    val repository = CursosRepository()
    val courses = runBlocking { repository.getCursos() }
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFF000080)) // Navy blue color
                .padding(horizontal = 8.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { showPresencialCourses() }
        ) {
            Text(text = "Cursos presenciales", color = Color.White )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center ,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFF000080))
                .padding(horizontal = 8.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { showOnlineCourses() }
        ) {
            Text(text = "Cursos online", color = Color.White )
        }

        LazyColumn(state = scrollState) {
            itemsIndexed(courses.chunked(2)) { index, pair ->
                Row {
                    pair.forEach { course ->
                        CourseItem(course)
                    }
                }
            }
        }
    }
}


fun showPresencialCourses() {


}


fun showOnlineCourses() {
    
}

@Composable
fun CourseItem(course: CursosAula) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Course Name: ${course.nombre}")
            Text(text = "Course ID: ${course.id}")
            Text(text = "Course Category: ${course.categoria}")
            Text(text = "Course Description: ${course.descripcion}")
            Text(text = "Course Address: ${course.direccion}")
            Text(text = "Course Price: ${course.precio}")
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}