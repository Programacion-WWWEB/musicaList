package com.example.musicalist;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
public class GeneroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    public void testAgregar() throws Exception {
        String jsonPayload = "{\n" +
        
        "\"nombre\": \"Rock\"\n" +
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
        "\"nombre\": \"Rock\"\n" +
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

        String jsonPayload = "{\n" +
        
        "\"nombre\": \"Rock\"\n" +
        "}";
        MvcResult generoResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/Genero/Agregar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
                 ObjectMapper objectMapper = new ObjectMapper();
JsonNode albumNode = objectMapper.readTree(generoResult.getResponse().getContentAsString());
long id = albumNode.get("id").asLong();
        mockMvc.perform(MockMvcRequestBuilders
                .get("/Genero/Buscar/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
                
    }

  /*  @Test
    @Transactional
    public void testEliminar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/Genero/Borrar/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }*/

    @Test
    @Transactional
    public void testEliminarGenero() throws Exception {
        String jsonPayload = "{\n" +
        "\"id\": 1,\n" +
        "\"nombre\": \"Rock\"\n" +
        "}";
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/Genero/Borrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}

