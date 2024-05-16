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

import com.example.demo.models.CursoModel;
import com.example.demo.services.CursoServices;

@RestController
@RequestMapping("/curso")
public class CursoController{
    @Autowired
    CursoServices cursoServices;

    @GetMapping()
    public ArrayList<CursoModel> obtenerCursos(){
        return cursoServices.obtenerCursos();
    }

    @PostMapping()
    public CursoModel guardarUsuario(@RequestBody CursoModel curso){
        return this.cursoServices.guardarCurso(curso);
    }
    
    @GetMapping("/{id}")
	public Optional<CursoModel> obtenerCursoPorId(@PathVariable("id") Long id) {
		return this.cursoServices.obtenerPorId(id);
	}
    
    @GetMapping("/query-precio")
	public ArrayList<CursoModel> obtenerCursoPorPrecio(@RequestParam("precio") Float precio) {
		return this.cursoServices.obtenerPorPrecio(precio);
	}
    
    @GetMapping("/query-categoria")
	public ArrayList<CursoModel> obtenerCursoPorCategoria(@RequestParam("categoria") String categoria) {
		return this.cursoServices.obtenerPorCategoria(categoria);
	}
    
    @GetMapping("/query-direccion")
	public ArrayList<CursoModel> obtenerCursoPorDireccion(@RequestParam("direccion") String direccion) {
		return this.cursoServices.obtenerPorDireccion(direccion);
	}
    
    @DeleteMapping("/{id}")
        public ResponseEntity<?> eliminarPorId(@PathVariable("id") Long id) {
			if (this.cursoServices.eliminarCurso(id)) {
				return ResponseEntity.status(204).body("");
			} else {
				return ResponseEntity.notFound().build();
			}
    }
    
    @PutMapping("/{id}")
	public String actualizarCurso(@PathVariable("id") Long id, @RequestBody CursoModel curso) {
		boolean ok = this.cursoServices.actualizarCurso(id, curso);
		if (ok) {
			return "Se actualizó el curso con id " + id;
		} else {
			return "No se pudo actualizar el curso con id " + id;
		}
	}
}