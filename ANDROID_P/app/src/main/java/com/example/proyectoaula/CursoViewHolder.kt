package com.example.proyectoaula

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoaula.databinding.ItemCursoBinding

class CursoViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemCursoBinding.bind(view)
    fun bind(texto: String){
        binding.tvCurso.text = texto
    }
}