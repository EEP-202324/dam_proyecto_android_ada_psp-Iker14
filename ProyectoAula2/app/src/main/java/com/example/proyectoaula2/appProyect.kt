package com.example.proyectoaula2



import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoaula2.viewmodel.CursosViewModel
import com.example.proyectoaula2.api.cursosApi
import com.example.proyectoaula2.main2.screens.FormularioScreen

import com.example.proyectoaula2.main2.screens.HomeScreen
import com.example.proyectoaula2.main2.screens.OnlineScreen
import com.example.proyectoaula2.main2.screens.PresencialScreen


import com.example.proyectoaula2.ui.theme.ProyectoAula2Theme

@SuppressLint("SuspiciousIndentation")
@Composable
fun ControlVentana() {
    val navController = rememberNavController()
    val cursosViewModel: CursosViewModel = viewModel()

    ProyectoAula2Theme {
        Scaffold (
            topBar = {
                // AppTopBar(), si tienes una barra superior
            }
        ) { innerPadding ->
            NavHost(navController = navController, startDestination = "home", modifier = Modifier.padding(innerPadding)) {
                composable("home") {
                    HomeScreen(navController = navController)
                }
                composable("online") {
                    OnlineScreen(navController = navController, tipo = "online")
                }
                composable("presencial") {
                    OnlineScreen(navController = navController, tipo = "presencial")
                }
                composable("formulario") {
                    FormularioScreen(navController = navController)
                }
            }
        }
    }
}
//@Composable
// fun ControlVentana() {
//     val navController = rememberNavController()
//    val repository = CursosRepository()
//
//        ProyectoAula2Theme {
//            Scaffold (
//                topBar = {
//                    //AppTopBar()
//                }
//            ){innerPadding ->
//                NavHost(navController = navController, startDestination = "home", modifier = Modifier.padding(innerPadding)) {
//                    composable("home") {
//                        HomeScreen(navController = navController)
//                    }
//                    composable("presencial") {
//                        PresencialScreen(navController = navController, repository = repository)
//                    }
//                    composable("online") {
//                        OnlineScreen(navController = navController)
//                    }
//                    composable("formulario") {
//                        FormularioScreen(navController = navController)
//                    }
//
//
//            }
//            }
//        }
// }