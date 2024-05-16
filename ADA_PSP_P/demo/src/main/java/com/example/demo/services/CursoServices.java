package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.CursoModel;
import com.example.demo.repositories.CursoRepositories;


@Service
public class CursoServices {
    @Autowired
    CursoRepositories cursoRepositories;

    public ArrayList<CursoModel> obtenerCursos(){
        return (ArrayList<CursoModel>) cursoRepositories.findAll();
    }

    public CursoModel guardarCurso(CursoModel curso){
        return cursoRepositories.save(curso);
    }
    
	public Optional<CursoModel> obtenerPorId(Long id) {
		return cursoRepositories.findById(id);
	}
	
	public ArrayList<CursoModel> obtenerPorPrecio(Float precio) {
		return cursoRepositories.findByPrecio(precio);
	}
	
	public ArrayList<CursoModel> obtenerPorCategoria(String categoria) {
		return cursoRepositories.findByCategoria(categoria);
	}
	
	public ArrayList<CursoModel> obtenerPorDireccion(String direccion) {
		return cursoRepositories.findByDireccion(direccion);
	}
	
	
	public boolean eliminarCurso(Long id) {
		try {
			cursoRepositories.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean actualizarCurso(Long id, CursoModel curso) {
		try {
			cursoRepositories.save(curso);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
		
}