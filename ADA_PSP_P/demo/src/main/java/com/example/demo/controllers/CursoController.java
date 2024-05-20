package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class CursoController {
    @Autowired
    private CursoServices cursoServices;

    @GetMapping()
    public ResponseEntity<ArrayList<CursoModel>> obtenerCursos() {
        ArrayList<CursoModel> cursos = cursoServices.obtenerCursos();
        return ResponseEntity.ok(cursos);
    }

    @PostMapping()
    public ResponseEntity<CursoModel> guardarCurso(@RequestBody CursoModel curso) {
        CursoModel guardado = cursoServices.guardarCurso(curso);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoModel> obtenerCursoPorId(@PathVariable("id") Long id) {
        Optional<CursoModel> curso = cursoServices.obtenerPorId(id);
        return curso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/query-precio")
    public ResponseEntity<ArrayList<CursoModel>> obtenerCursoPorPrecio(@RequestParam("precio") Float precio) {
        ArrayList<CursoModel> cursos = cursoServices.obtenerPorPrecio(precio);
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/query-categoria")
    public ResponseEntity<ArrayList<CursoModel>> obtenerCursoPorCategoria(@RequestParam("categoria") String categoria) {
        ArrayList<CursoModel> cursos = cursoServices.obtenerPorCategoria(categoria);
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/query-direccion")
    public ResponseEntity<ArrayList<CursoModel>> obtenerCursoPorDireccion(@RequestParam("direccion") String direccion) {
        ArrayList<CursoModel> cursos = cursoServices.obtenerPorDireccion(direccion);
        return ResponseEntity.ok(cursos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable("id") Long id) {
        if (cursoServices.eliminarCurso(id)) {
            return ResponseEntity.noContent().build();  // 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoModel> actualizarCurso(@PathVariable("id") Long id, @RequestBody CursoModel curso) {
        CursoModel actualizado = cursoServices.actualizarCurso(id, curso);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);  
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
        }
    }

}
