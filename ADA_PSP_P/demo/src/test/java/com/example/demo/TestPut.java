package com.example.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.models.CursoModel;
import com.example.demo.services.CursoServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class TestPut {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CursoServices cursoServices;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void actualizarCurso_CursoExistente_DeberiaRetornarCursoActualizado() throws Exception {
        CursoModel cursoExistente = new CursoModel();
        cursoExistente.setId(1L);
        cursoExistente.setNombre("Curso Actualizado");

        when(cursoServices.actualizarCurso(eq(1L), any(CursoModel.class))).thenReturn(cursoExistente);

        mockMvc.perform(put("/curso/{id}", 1)
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cursoExistente)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre").value("Curso Actualizado"));
    }

    @Test
    public void actualizarCurso_CursoNoExistente_DeberiaRetornarBadRequest() throws Exception {
        when(cursoServices.actualizarCurso(eq(99L), any(CursoModel.class))).thenReturn(null);

        mockMvc.perform(put("/curso/{id}", 99)
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new CursoModel())))
            .andExpect(status().isBadRequest());
    }
}
