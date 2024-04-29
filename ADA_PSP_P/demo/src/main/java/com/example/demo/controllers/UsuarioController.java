package  com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioServices;

@RestController
@RequestMapping("/curso")
public class UsuarioController{
    @Autowired
    UsuarioServices usuarioServices;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerCursos(){
        return usuarioServices.obtenerCursos();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel curso){
        return this.usuarioServices.guardarCurso(curso);
    }
    
    @GetMapping( path = "/{id}")
	public Optional<UsuarioModel> obtenerCursoPorId(@PathVariable("id") Long id) {
		return this.usuarioServices.obtenerPorId(id);
	}
    
    @GetMapping("/query")
	public ArrayList<UsuarioModel> obtenerCursoPorPrecio(@RequestParam("precio") Float precio) {
		return this.usuarioServices.obtenerPorPrecio(precio);
	}
    
    @DeleteMapping( path = "/{id}")
        public String eliminarPorId(@PathVariable("id") Long id) {
			boolean ok = this.usuarioServices.eliminarCurso(id);
			if (ok) {
				return "Se eliminó el curso con id " + id;
			} else {
				return "No se pudo eliminar el curso con id " + id;
			}
    }
}