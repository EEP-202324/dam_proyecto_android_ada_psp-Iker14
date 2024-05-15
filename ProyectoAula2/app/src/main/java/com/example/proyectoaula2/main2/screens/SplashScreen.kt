package com.example.proyectoaula2.main2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectoaula2.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.mipmap.logo_app_foreground),
            contentDescription = "Logo de la App",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
        )
    }

    LaunchedEffect(Unit) {
        delay(5000)
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }
    }
}