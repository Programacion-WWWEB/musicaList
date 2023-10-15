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
@Transactional
public class VotoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testVotoAgregar() throws Exception{

        String jsonPayload = "{\n" +
        "\"id\": 1,\n" + 
        "\"track_id\": 10,\n" +  
        "\"usuario_votante\":{\n" +
        " \"nombre\": \"usuario\",\n" +
        " \"nombrePerfil\": \"usuarioPerfil\",\n" +
        " \"contrasena\": \"contrasena\",\n" +
        " \"correo\": \"frde@ase\"\n" +
        "},\n" +
        "\"track\":{\n" +
        "    \"title\": \"Cristaux liquides\",\n" +
        "    \"album\": {\n" +
        "        \"album_id\": 1,\n" +
        "        \"name\": \"Palais d'argile\"\n" +
        "    }\n" +
        "}\n" +
        "}";

        mockMvc.perform(MockMvcRequestBuilders
            .post("/Voto/Agregar")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonPayload)) // Set the JSON payload
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testVotoLista() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/Voto/Lista")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    
}
