package com.example.musicalist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class AlbumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //Tets agregar album
    @Test
    public void testAgregar() throws Exception {

     /*  String token = mockMvc.perform(MockMvcRequestBuilders
        .post("http://localhost:8081/public/autenticacion-usuario")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .param("correo", "your_username")
        .param("contrasena", "your_password"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();
        
        String jsonPayload = "{\n" +
        "\"album_id\": 33,\n" +
        "\"name\": \"Palais d'argile\",\n" +
        "\"artist\": \"Feu! Chatterton\",\n" +
        "\"type\": \"Album\",\n" +
        "\"release_date\": \"2012-02-02T00:00:00.000+00:00\",\n" +
        "\"rym_rating\": 3.52,\n" +
        "\"language\": \"French\",\n" +
        "\"genres\": \"Art Pop, Art Rock\\nIndietronica, Neo-Psychedelia, Synthpop, Progressive Pop\",\n" +
        "\"colorscheme\": \"#0d196d\"\n" +
        "}";
        
        mockMvc.perform(MockMvcRequestBuilders
                .post("/Album/Agregar")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .content(jsonPayload))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    */
}
}