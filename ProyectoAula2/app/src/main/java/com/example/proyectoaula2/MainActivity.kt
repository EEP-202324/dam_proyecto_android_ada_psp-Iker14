package com.example.proyectoaula2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavController
import com.example.proyectoaula2.ui.theme.ProyectoAula2Theme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAula2Theme {
                ControlVentana()

            }
        }
    }


}


