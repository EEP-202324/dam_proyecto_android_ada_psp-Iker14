package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.CursoModel;


@Repository
public interface CursoRepositories extends CrudRepository<CursoModel, Long>{
	public abstract ArrayList<CursoModel> findByPrecio(Float precio);
	public abstract ArrayList<CursoModel> findByCategoria(String categoria);
	public abstract ArrayList<CursoModel> findByDireccion(String direccion);
}
