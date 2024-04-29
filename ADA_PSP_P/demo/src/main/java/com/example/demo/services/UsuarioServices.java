package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepositories;


@Service
public class UsuarioServices {
    @Autowired
    UsuarioRepositories usuarioRepositories;

    public ArrayList<UsuarioModel> obtenerCursos(){
        return (ArrayList<UsuarioModel>) usuarioRepositories.findAll();
    }

    public UsuarioModel guardarCurso(UsuarioModel curso){
        return usuarioRepositories.save(curso);
    }
    
	public Optional<UsuarioModel> obtenerPorId(Long id) {
		return usuarioRepositories.findById(id);
	}
	
	public ArrayList<UsuarioModel> obtenerPorPrecio(Float precio) {
		return usuarioRepositories.findByPrecio(precio);
	}
	
	
	public boolean eliminarCurso(Long id) {
		try {
			usuarioRepositories.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}