package com.example.demo.services;

import java.util.ArrayList;
import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServices {
    @Autowired
    UsuarioRepositories usuarioRepositories;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepositories.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepositories.save(usuario);
    }
}