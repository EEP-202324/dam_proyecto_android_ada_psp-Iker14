package com.example.proyectoaula2.main2

import java.sql.Connection
import java.sql.DriverManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object DatabaseUtils {
    suspend fun connectToDatabase(): Connection? = withContext(Dispatchers.IO) {
        val url = "jdbc:mysql://localhost:3306/proyecto"
        val username = "root"
        val password = "1234"

        DriverManager.getConnection(url, username, password)
    }
}