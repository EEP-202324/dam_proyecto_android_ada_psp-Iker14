package com.example.proyectoaula

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoaula.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initRecyclerView()
        binding.Curso.setOnQueryTextListener(this)
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByName(query.toLowerCase())
        }
        return true
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://localhost:8080/curso/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun searchByName(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getCursosBydireccion("$query/direccion")
            val tipo = call.body()
            runOnUiThread {
                if(call.isSuccessful){
                    val cursos = tipo?.datos ?: emptyList()
                    cursoTextos.clear()
                    cursoTextos.addAll(cursos)
                    adapter.notifyDataSetChanged()
                }else{
                    showError()
                }
                hideKeyboard()
            }
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
    }

    private fun searchByCategory(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getCursosBydireccion("$query/categoria")
            val tipo = call.body()
            if(call.isSuccessful){
                //show Recyclerview
            }else{
                //show error
            }
        }
    }

    private fun searchByPrice(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getCursosBydireccion("$query/precio")
            val tipo = call.body()
            if(call.isSuccessful){
                //show Recyclerview
            }else{
                //show error
            }
        }
    }

    private lateinit var adapter: CursoAdapter
    private val cursoTextos = mutableListOf<String>()


    private fun initRecyclerView() {
        adapter = CursoAdapter(cursoTextos)
        binding.Cursos.layoutManager = LinearLayoutManager(this)
        binding.Cursos.adapter = adapter
    }

    private fun searchCursos(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getCursosBydireccion("cursos")
            val tipo = call.body()
            if(call.isSuccessful){
                //show Recyclerview
            }else{
                //show error
            }
        }
    }

}

private fun <LinearLayoutCompat> LinearLayoutCompat.setOnQueryTextListener(mainActivity: MainActivity) {

}
