package com.example.demo;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.models.CursoModel;
import com.example.demo.services.CursoServices;

@SpringBootTest
@AutoConfigureMockMvc

public class DireccionYPrecioTest {
	@MockBean
    private CursoServices usuarioServices;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testObtenerCursoPorDireccion() throws Exception {
        // Crear datos de prueba
        CursoModel usuario1 = new CursoModel();
        usuario1.setDireccion("direccion1");
        CursoModel usuario2 = new CursoModel();
        usuario2.setDireccion("direccion2");
        ArrayList<CursoModel> listaUsuarios = new ArrayList<>(Arrays.asList(usuario1, usuario2));

        // Configurar el mock para devolver los datos de prueba cuando se llame al método obtenerPorDireccion()
        when(usuarioServices.obtenerPorDireccion("direccion1")).thenReturn(listaUsuarios);

        // Realizar la petición GET al endpoint /query-direccion y verificar la respuesta
        mockMvc.perform(MockMvcRequestBuilders.get("/curso/query-direccion")
                .param("direccion", "direccion1")
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].direccion").value("direccion1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].direccion").value("direccion2"));
    }
    
    @Test
	public void testObtenerCursoPorPrecio() throws Exception {
	    // Crear datos de prueba
	    CursoModel usuario1 = new CursoModel();
	    usuario1.setPrecio(100.0f);
	    CursoModel usuario2 = new CursoModel();
	    usuario2.setPrecio(200.0f);
	    ArrayList<CursoModel> listaUsuarios = new ArrayList<>(Arrays.asList(usuario1, usuario2));

	    // Configurar el mock para devolver los datos de prueba cuando se llame al método obtenerPorPrecio()
	    when(usuarioServices.obtenerPorPrecio(100.0f)).thenReturn(listaUsuarios);
	    

	    // Realizar la petición GET al endpoint /query-precio y verificar la respuesta
	    mockMvc.perform(MockMvcRequestBuilders.get("/curso/query-precio")
	            .param("precio", "100.0")
	            .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
	            .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
	            .andExpect(MockMvcResultMatchers.jsonPath("$[0].precio").value(Matchers.greaterThan(0.0)))
	            .andExpect(MockMvcResultMatchers.jsonPath("$[1].precio").value(Matchers.greaterThan(0.0)));
	}
    
    
}
