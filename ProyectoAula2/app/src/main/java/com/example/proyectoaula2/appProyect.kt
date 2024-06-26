package com.example.proyectoaula2



import FormularioScreen
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoaula2.main2.screens.EditScreen
import com.example.proyectoaula2.main2.screens.HomeScreen
import com.example.proyectoaula2.main2.screens.OnlineScreen
import com.example.proyectoaula2.main2.screens.PresencialScreen
import com.example.proyectoaula2.main2.screens.SplashScreen


import com.example.proyectoaula2.ui.theme.ProyectoAula2Theme

@SuppressLint("SuspiciousIndentation")
@Composable
fun ControlVentana() {
    val navController = rememberNavController()

    ProyectoAula2Theme {
        Scaffold (
            // topBar = { AppTopBar() } si tienes una barra superior
        ) { innerPadding ->
            NavHost(navController = navController, startDestination = "splash", modifier = Modifier.padding(innerPadding)) {
                composable("splash") { SplashScreen(navController) }
                composable("home") { HomeScreen(navController) }
                composable("online") { OnlineScreen(navController = navController, tipo = "online") }
                composable("presencial") { PresencialScreen(navController = navController, tipo = "presencial") }
                composable("formulario") { FormularioScreen(navController = navController) }
                composable("edit/{cursoId}") { backStackEntry ->
                    val cursoId = backStackEntry.arguments?.getString("cursoId")
                    if (cursoId != null) {
                        EditScreen(navController = navController, cursoId = cursoId)
                    }
                }

            }
        }
    }
}



