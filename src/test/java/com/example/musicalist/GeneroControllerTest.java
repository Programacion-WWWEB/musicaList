package com.example.musicalist;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class GeneroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAgregar() throws Exception {
        String jsonPayload = "{\n" + 
            "\"id\": 1,\n" + 
            "\"nombre\": \"Rock\",\n" + 
            "\"descripcion\": \"Genero musical que se caracteriza por la utilizacion de guitarras electricas, bateria y bajo\"\n" + 
            "}";
        mockMvc.perform(MockMvcRequestBuilders
                .post("/Genero/Agregar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testActualizar() throws Exception {
        String jsonPayload = "{\n" + 
            "\"id\": 1,\n" + 
            "\"nombre\": \"Rock\",\n" + 
            "\"descripcion\": \"Genero musical que se caracteriza por la utilizacion de guitarras electricas, bateria y bajo\"\n" + 
            "}";
        mockMvc.perform(MockMvcRequestBuilders
                .put("/Genero/Actualizar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testListar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/Genero/Lista")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void testBuscar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/Genero/Buscar/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
                
    }

    @Test
    @Transactional
    public void testEliminar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/Genero/Borrar/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Transactional
    public void testEliminarGenero() throws Exception {
        String jsonPayload = "{\n" + 
            "\"id\": 1,\n" + 
            "\"nombre\": \"Rock\",\n" + 
            "\"descripcion\": \"Genero musical que se caracteriza por la utilizacion de guitarras electricas, bateria y bajo\"\n" + 
            "}";
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/Genero/Borrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}

