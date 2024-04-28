package  com.example.demo.controllers;

import java.util.ArrayList;
import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController{
    @Autowired
    UsuarioServices usuarioServices;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioServices.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioServices.guardarUsuario(usuario);
    }
}