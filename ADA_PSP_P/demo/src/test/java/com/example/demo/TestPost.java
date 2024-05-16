package com.example.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.models.CursoModel;
import com.example.demo.services.CursoServices;

@SpringBootTest
@AutoConfigureMockMvc
public class TestPost {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CursoServices cursoServices;

    @Test
    public void guardarCurso_cursoGuardado_statusOk() throws Exception {
        CursoModel nuevoCurso = new CursoModel();
        nuevoCurso.setNombre("Curso de Java");
        nuevoCurso.setPrecio(150.0f);

        when(cursoServices.guardarCurso(any(CursoModel.class))).thenReturn(nuevoCurso);

        mockMvc.perform(post("/curso")
                .contentType(APPLICATION_JSON)
                .content("{\"nombre\":\"Curso de Java\", \"precio\":150.0}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre", is("Curso de Java")))
            .andExpect(jsonPath("$.precio", is(150.0)));
    }

    @Test
    public void guardarCurso_datosInvalidos_statusBadRequest() throws Exception {
        when(cursoServices.guardarCurso(any(CursoModel.class))).thenThrow(new RuntimeException("Datos inválidos"));

        mockMvc.perform(post("/curso")
                .contentType(APPLICATION_JSON)
                .content("{\"nombre\":\"\"}")) 
            .andExpect(status().isBadRequest());
    }
}
