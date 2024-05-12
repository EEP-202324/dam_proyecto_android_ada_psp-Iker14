import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.proyectoaula2.main2.*
import androidx.compose.material3.Card


@Composable
fun PresencialScreen(navController: NavController, repository: CursosRepository) {
    val viewModel: CursosViewModel = viewModel(factory = CursosViewModelFactory(repository))
    val cursosPresenciales = viewModel.cursosPresenciales.observeAsState(listOf())

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(cursosPresenciales.value) { curso ->
                CursoItem(curso)
            }
        }
    }
}

@Composable
fun CursoItem(curso: CursosAula) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFF000080)),
                contentAlignment = Alignment.Center
            ) {
                Text("Imagen", color = Color.White)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = curso.nombre, style = MaterialTheme.typography.titleMedium)
                Text(text = curso.descripcion, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Precio: ${curso.precio}", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}


//@Composable
//fun CursoItem(curso: CursosAula) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp),
//        shape = RoundedCornerShape(10.dp),
//        elevation = 5.dp
//    ) {
//        Row(modifier = Modifier.padding(16.dp)) {
//            Box(
//                modifier = Modifier
//                    .size(100.dp)
//                    .background(Color(0xFF000080)),
//                contentAlignment = Alignment.Center
//            ) {
//                Text("Imagen", color = Color.White)
//            }
//            Spacer(modifier = Modifier.width(16.dp))
//            Column {
//                Text(text = curso.nombre, style = MaterialTheme.typography.h6)
//                Text(text = curso.descripcion, style = MaterialTheme.typography.body2)
//                Spacer(modifier = Modifier.height(4.dp))
//                // Suponiendo que tienes un campo adicional como 'precio'
//                Text(text = "Precio: ${curso.precio}", style = MaterialTheme.typography.body1)
//            }
//        }
//    }
//}