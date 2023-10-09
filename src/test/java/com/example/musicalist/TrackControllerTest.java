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
public class TrackControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testBuscar() throws Exception {
        // Define the JSON payload
        String jsonPayload = "{\n" +
                "    \"title\": \"Un monde nouveau\",\n" +
                "    \"album\": {\n" +
                "        \"album_id\": 1,\n" +
                "        \"name\": \"Palais d'argile\"\n" +
                "    }\n" +
                "}";
    
        // Perform the POST request with the JSON payload
        mockMvc.perform(MockMvcRequestBuilders
                .post("/Track/Agregar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload)) // Set the JSON payload
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    
}
