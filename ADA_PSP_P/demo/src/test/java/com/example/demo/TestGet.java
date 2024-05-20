package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Optional;

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
public class TestGet {

    @MockBean
    private CursoServices cursoServices;

    @Autowired
    private MockMvc mockMvc;

    

    @Test
    public void obtenerCursoPorId_cursoExistente_statusOk() throws Exception {
        CursoModel curso = new CursoModel(); 
        when(cursoServices.obtenerPorId(1L)).thenReturn(Optional.of(curso));

        mockMvc.perform(get("/curso/{id}", 1))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.nombre", is(curso.getNombre())));
    }

    @Test
    public void obtenerCursoPorId_cursoNoExistente_statusNotFound() throws Exception {
        when(cursoServices.obtenerPorId(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/curso/{id}", 1))
               .andExpect(status().isNotFound());
    }
}
