package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

public class VerbosTest {

	@SpringBootTest
	@AutoConfigureMockMvc
	public class UsuarioControllerTest {

		@Autowired
		private MockMvc mockMvc;

		@Test
		public void testGetCursos() throws Exception {
			this.mockMvc.perform(get("/curso")).andExpect(status().isOk());
		}

		@Test
		public void testGetCursoPorNombre() throws Exception {
			this.mockMvc.perform(get("/curso/query-nombre").param("nombre", "Curso de prueba"))
					.andExpect(status().isOk());
		}

		@Test
		public void testDeleteCurso() throws Exception {
			this.mockMvc.perform(delete("/curso/{id}", 1L)).andExpect(status().isOk());
		}

		@Test
		public void testDeleteEliminarPorNombre() throws Exception {
			this.mockMvc.perform(delete("/curso/eliminar-por-nombre").param("nombre", "Curso de prueba"))
					.andExpect(status().isOk());
		}

		@Test
		public void testPutCurso() throws Exception {
			String cursoJson = "{\"nombre\":\"Curso de prueba\",\"precio\":100.0,\"categoria\":\"Categoria de prueba\",\"direccion\":\"Direccion de prueba\"}";
			this.mockMvc.perform(put("/curso/{id}", 1L).contentType(MediaType.APPLICATION_JSON).content(cursoJson))
					.andExpect(status().isOk());
		}

		@Test
		public void testPutActualizarPrecio() throws Exception {
			this.mockMvc.perform(put("/curso/{id}/actualizar-precio", 1L).param("precio", "150.0"))
					.andExpect(status().isOk());
		}

		@Test
		public void testPostCurso() throws Exception {
			String cursoJson = "{\"nombre\":\"Curso de prueba\",\"precio\":100.0,\"categoria\":\"Categoria de prueba\",\"direccion\":\"Direccion de prueba\"}";
			this.mockMvc.perform(post("/curso").contentType(MediaType.APPLICATION_JSON).content(cursoJson))
					.andExpect(status().isOk());
		}

		@Test
		public void testPostCursosMasivo() throws Exception {
			String cursosJson = "[{\"nombre\":\"Curso de prueba 1\",\"precio\":100.0,\"categoria\":\"Categoria de prueba\",\"direccion\":\"Direccion de prueba\"},{\"nombre\":\"Curso de prueba 2\",\"precio\":200.0,\"categoria\":\"Categoria de prueba\",\"direccion\":\"Direccion de prueba\"}]";
			this.mockMvc.perform(post("/curso/masivo").contentType(MediaType.APPLICATION_JSON).content(cursosJson))
					.andExpect(status().isOk());
		}

	}
}
