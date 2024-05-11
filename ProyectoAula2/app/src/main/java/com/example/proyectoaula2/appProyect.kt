package com.example.proyectoaula2

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoaula2.main2.screens.FormularioScreen
import com.example.proyectoaula2.main2.screens.HomeScreen
import com.example.proyectoaula2.main2.screens.OnlineSreen
import com.example.proyectoaula2.main2.screens.PresencialScreen
import com.example.proyectoaula2.ui.theme.ProyectoAula2Theme

@SuppressLint("SuspiciousIndentation")
@Composable
 fun ControlVentana() {
     val navController = rememberNavController()
        ProyectoAula2Theme {
            Scaffold (
                topBar = {
                    //AppTopBar()
                }
            ){innerPadding ->
                NavHost(navController = navController, startDestination = "home", modifier = Modifier.padding(innerPadding)) {
                    composable("home") {
                        HomeScreen(navController = navController)
                    }
                    composable("presencial") {
                        PresencialScreen(navController = navController)
                    }
                    composable("online") {
                        OnlineSreen(navController = navController)
                    }
                    composable("formulario") {
                        FormularioScreen(navController = navController)
                    }

            }
            }
        }
 }