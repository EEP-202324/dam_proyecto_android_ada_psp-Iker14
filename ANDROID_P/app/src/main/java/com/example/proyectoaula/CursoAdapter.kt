package com.example.proyectoaula

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CursoAdapter(private val textos: List<String>) : RecyclerView.Adapter<CursoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CursoViewHolder(layoutInflater.inflate(R.layout.item_curso, parent, false))
    }

    override fun getItemCount(): Int = textos.size

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        val texto = textos[position]
        holder.bind(texto)
    }
}