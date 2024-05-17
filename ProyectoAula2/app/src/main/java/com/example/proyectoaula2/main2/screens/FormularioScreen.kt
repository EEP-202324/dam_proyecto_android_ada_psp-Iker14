import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.proyectoaula2.main2.CursosAula
import com.example.proyectoaula2.viewmodel.CursosViewModel

@Composable
fun FormularioScreen(navController: NavController) {
    val viewModel: CursosViewModel = viewModel()
    val context = LocalContext.current
    var categoria by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("online") } // Inicializa con "online"
    var id by remember { mutableIntStateOf(0) }
    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        TextField(
            value = categoria,
            onValueChange = { categoria = it },
            label = { Text("Categoría") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        TextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        TextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Online",
                modifier = Modifier.padding(start = 8.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(start = 16.dp)
            ) {
                RadioButton(
                    selected = direccion == "online",
                    onClick = { direccion = "online" },
                    colors = RadioButtonDefaults.colors(selectedColor = Color.Black)
                )
            }
            Text(
                "Presencial",
                modifier = Modifier.padding(start = 16.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(start = 16.dp)
            ) {
                RadioButton(
                    onClick = { direccion = "presencial" },
                    selected = direccion == "presencial",
                    colors = RadioButtonDefaults.colors(selectedColor = Color.Black)
                )
            }
        }

        Button(
            onClick = {
                val newCourse =
                    CursosAula(categoria, descripcion, direccion, id, nombre, precio.toFloat())
                viewModel.createCourse(newCourse)
                navController.popBackStack()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Añadir curso")
        }
    }
}