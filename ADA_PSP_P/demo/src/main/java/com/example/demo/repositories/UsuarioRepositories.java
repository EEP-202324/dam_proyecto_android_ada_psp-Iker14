package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UsuarioModel;


@Repository
public interface UsuarioRepositories extends CrudRepository<UsuarioModel, Long>{
	public abstract ArrayList<UsuarioModel> findByPrecio(Float precio);
}
