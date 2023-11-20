package com.example.musicalist;

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
public class AlbumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //Tets agregar album
    @Test
    public void testAgregar() throws Exception {
        
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
                .content(jsonPayload))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}
