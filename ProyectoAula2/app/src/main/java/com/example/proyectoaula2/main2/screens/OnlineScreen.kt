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
import androidx.navigation.NavController
import com.example.proyectoaula2.main2.CursosAula
import java.lang.reflect.Modifier


@Composable
fun OnlineScreen(navController: NavController) {
    val courses = remember { mutableStateOf(listOf<CursosAula>()) }

    LaunchedEffect(Unit) {
        courses.value = fetchOnlineCoursesFromApi()
    }


}


