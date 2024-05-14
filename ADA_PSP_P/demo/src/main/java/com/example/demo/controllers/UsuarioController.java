package  com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @GetMapping("/{id}")
	public Optional<UsuarioModel> obtenerCursoPorId(@PathVariable("id") Long id) {
		return this.usuarioServices.obtenerPorId(id);
	}
    
    @GetMapping("/query-precio")
	public ArrayList<UsuarioModel> obtenerCursoPorPrecio(@RequestParam("precio") Float precio) {
		return this.usuarioServices.obtenerPorPrecio(precio);
	}
    
    @GetMapping("/query-categoria")
	public ArrayList<UsuarioModel> obtenerCursoPorCategoria(@RequestParam("categoria") String categoria) {
		return this.usuarioServices.obtenerPorCategoria(categoria);
	}
    
    @GetMapping("/query-direccion")
	public ArrayList<UsuarioModel> obtenerCursoPorDireccion(@RequestParam("direccion") String direccion) {
		return this.usuarioServices.obtenerPorDireccion(direccion);
	}
    
    @DeleteMapping("/{id}")
        public ResponseEntity<?> eliminarPorId(@PathVariable("id") Long id) {
			if (this.usuarioServices.eliminarCurso(id)) {
				return ResponseEntity.status(204).body("");
			} else {
				return ResponseEntity.notFound().build();
			}
    }
    
    @PutMapping("/{id}")
	public String actualizarCurso(@PathVariable("id") Long id, @RequestBody UsuarioModel curso) {
		boolean ok = this.usuarioServices.actualizarCurso(id, curso);
		if (ok) {
			return "Se actualizó el curso con id " + id;
		} else {
			return "No se pudo actualizar el curso con id " + id;
		}
	}
}