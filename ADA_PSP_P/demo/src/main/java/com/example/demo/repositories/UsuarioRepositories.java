package com.example.demo.repositories;

import com.example.demo.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@repository
public interface UsuarioRepositories extends CrudRepository<UsuarioModel, Long>{
}