package com.example.demo;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.models.CursoModel;
import com.example.demo.services.CursoServices;

@WebMvcTest
public class TestPut {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CursoServices cursoServices;

    @BeforeEach
    public void setup(WebApplicationContext webApplicationContext) {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void actualizarCurso_cursoExistente_statusOk() throws Exception {
        when(cursoServices.actualizarCurso(eq(1L), any(CursoModel.class))).thenReturn(true);

        mockMvc.perform(put("/curso/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Curso Actualizado\"}"))
            .andExpect(status().isOk())
            .andExpect(content().string("Se actualizó el curso con id 1"));
    }

    @Test
    public void actualizarCurso_cursoNoExistente_statusBadRequest() throws Exception {
        when(cursoServices.actualizarCurso(eq(99L), any(CursoModel.class))).thenReturn(false);

        mockMvc.perform(put("/curso/{id}", 99)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Curso No Existente\"}"))
            .andExpect(status().isOk())
            .andExpect(content().string("No se pudo actualizar el curso con id 99"));
    }
}
