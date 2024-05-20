package com.example.demo;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.services.CursoServices;

@WebMvcTest
public class TestDelete {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CursoServices cursoServices;

    @BeforeEach
    public void setup(WebApplicationContext webApplicationContext) {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void eliminarPorId_cursoExistente_statusNoContent() throws Exception {
        when(cursoServices.eliminarCurso(1L)).thenReturn(true);

        mockMvc.perform(delete("/curso/{id}", 1))
               .andExpect(status().isNoContent());
    }

    @Test
    public void eliminarPorId_cursoNoExistente_statusNotFound() throws Exception {
        when(cursoServices.eliminarCurso(99L)).thenReturn(false);

        mockMvc.perform(delete("/curso/{id}", 99))
               .andExpect(status().isNotFound());
    }
}
