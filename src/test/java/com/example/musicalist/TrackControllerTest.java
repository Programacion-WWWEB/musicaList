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
public class TrackControllerTest {
    /* 
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testBuscar() throws Exception {
        
        String albumJsonPayload = "{\n" +
        "    \"album_id\": 33,\n" +
        "    \"name\": \"Palais d'argile\",\n" +
        "    \"artist\": \"Feu! Chatterton\",\n" +
        "    \"type\": \"Album\",\n" +
        "    \"release_date\": \"2012-02-02T00:00:00.000+00:00\",\n" +
        "    \"rym_rating\": 3.52,\n" +
        "    \"language\": \"French\",\n" +
        "    \"genres\": \"Art Pop, Art Rock\\nIndietronica, Neo-Psychedelia, Synthpop, Progressive Pop\",\n" +
        "    \"colorscheme\": \"#0d196d\"\n" +
        "}";
    
    MvcResult albumResult = mockMvc.perform(MockMvcRequestBuilders
        .post("/Album/Agregar")
        .contentType(MediaType.APPLICATION_JSON)
        .content(albumJsonPayload))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();

    ObjectMapper objectMapper = new ObjectMapper();
JsonNode albumNode = objectMapper.readTree(albumResult.getResponse().getContentAsString());

// Extract the album ID from the JSON response
long albumId = albumNode.get("album_id").asLong();

    // Step 2: Create the track using the album ID
    String trackJsonPayload = "{\n" +
            "    \"title\": \"Un monde nouveau\",\n" +
            "    \"album\": {\n" +
            "        \"album_id\": " + albumId + ",\n" +
            "        \"name\": \"Palais d'argile\"\n" +
            "    }\n" +
            "}";
    
    MvcResult trackResult = mockMvc.perform(MockMvcRequestBuilders
            .post("/Track/Agregar")
            .contentType(MediaType.APPLICATION_JSON)
            .content(trackJsonPayload))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

    // Extract the track ID from the response
    ObjectMapper objectMapper2 = new ObjectMapper();
JsonNode trackNode = objectMapper2.readTree(trackResult.getResponse().getContentAsString());

// Extract the track ID from the JSON response
long trackId = trackNode.get("track_id").asLong(); 
    // Step 3: Delete the track
    mockMvc.perform(MockMvcRequestBuilders
            .get("/Track/Buscar/" + trackId)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Transactional
    public void testAgregar() throws Exception {
        // Define the JSON payload
        String albumJsonPayload = "{\n" +
        "    \"album_id\": 33,\n" +
        "    \"name\": \"Palais d'argile\",\n" +
        "    \"artist\": \"Feu! Chatterton\",\n" +
        "    \"type\": \"Album\",\n" +
        "    \"release_date\": \"2012-02-02T00:00:00.000+00:00\",\n" +
        "    \"rym_rating\": 3.52,\n" +
        "    \"language\": \"French\",\n" +
        "    \"genres\": \"Art Pop, Art Rock\\nIndietronica, Neo-Psychedelia, Synthpop, Progressive Pop\",\n" +
        "    \"colorscheme\": \"#0d196d\"\n" +
        "}";

MvcResult albumResult = mockMvc.perform(MockMvcRequestBuilders
        .post("/Album/Agregar")
        .contentType(MediaType.APPLICATION_JSON)
        .content(albumJsonPayload))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();

    // Extract the album ID from the response
 ObjectMapper objectMapper = new ObjectMapper();
JsonNode albumNode = objectMapper.readTree(albumResult.getResponse().getContentAsString());
long albumId = albumNode.get("album_id").asLong();

    // Step 2: Create the track using the album ID
    String trackJsonPayload = "{\n" +
            "    \"title\": \"Un monde nouveau\",\n" +
            "    \"album\": {\n" +
            "        \"album_id\": " + albumId + ",\n" +
            "        \"name\": \"Palais d'argile\"\n" +
            "    }\n" +
            "}";
    
    mockMvc.perform(MockMvcRequestBuilders
            .post("/Track/Agregar")
            .contentType(MediaType.APPLICATION_JSON)
            .content(trackJsonPayload))
            .andExpect(MockMvcResultMatchers.status().isOk());
            
    }

    @Test
    public void testActualizar() throws Exception {
        // Define the JSON payload
        String albumJsonPayload = "{\n" +
           "    \"album_id\": 33,\n" +
           "    \"name\": \"Palais d'argile\",\n" +
           "    \"artist\": \"Feu! Chatterton\",\n" +
           "    \"type\": \"Album\",\n" +
           "    \"release_date\": \"2012-02-02T00:00:00.000+00:00\",\n" +
           "    \"rym_rating\": 3.52,\n" +
           "    \"language\": \"French\",\n" +
           "    \"genres\": \"Art Pop, Art Rock\\nIndietronica, Neo-Psychedelia, Synthpop, Progressive Pop\",\n" +
           "    \"colorscheme\": \"#0d196d\"\n" +
           "}";
    
    MvcResult albumResult = mockMvc.perform(MockMvcRequestBuilders
            .post("/Album/Agregar")
            .contentType(MediaType.APPLICATION_JSON)
            .content(albumJsonPayload))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

    // Extract the album ID from the response
      ObjectMapper objectMapper = new ObjectMapper();
JsonNode albumNode = objectMapper.readTree(albumResult.getResponse().getContentAsString());
long albumId = albumNode.get("album_id").asLong();


    // Step 2: Create the track using the album ID
    String trackJsonPayload = "{\n" +
            "    \"title\": \"Un monde nouveau\",\n" +
            "    \"album\": {\n" +
            "        \"album_id\": " + albumId + ",\n" +
            "        \"name\": \"Palais d'argile\"\n" +
            "    }\n" +
            "}";
    
    mockMvc.perform(MockMvcRequestBuilders
            .post("/Track/Agregar")
            .contentType(MediaType.APPLICATION_JSON)
            .content(trackJsonPayload))
            .andExpect(MockMvcResultMatchers.status().isOk());
            
        
  }

    @Test
    public void testEliminar() throws Exception {
        
        String albumJsonPayload = "{\n" +
        "    \"album_id\": 33,\n" +
        "    \"name\": \"Palais d'argile\",\n" +
        "    \"artist\": \"Feu! Chatterton\",\n" +
        "    \"type\": \"Album\",\n" +
        "    \"release_date\": \"2012-02-02T00:00:00.000+00:00\",\n" +
        "    \"rym_rating\": 3.52,\n" +
        "    \"language\": \"French\",\n" +
        "    \"genres\": \"Art Pop, Art Rock\\nIndietronica, Neo-Psychedelia, Synthpop, Progressive Pop\",\n" +
        "    \"colorscheme\": \"#0d196d\"\n" +
        "}";
    
    MvcResult albumResult = mockMvc.perform(MockMvcRequestBuilders
        .post("/Album/Agregar")
        .contentType(MediaType.APPLICATION_JSON)
        .content(albumJsonPayload))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();

    ObjectMapper objectMapper = new ObjectMapper();
JsonNode albumNode = objectMapper.readTree(albumResult.getResponse().getContentAsString());

// Extract the album ID from the JSON response
long albumId = albumNode.get("album_id").asLong();

    // Step 2: Create the track using the album ID
    String trackJsonPayload = "{\n" +
            "    \"title\": \"Un monde nouveau\",\n" +
            "    \"album\": {\n" +
            "        \"album_id\": " + albumId + ",\n" +
            "        \"name\": \"Palais d'argile\"\n" +
            "    }\n" +
            "}";
    
    MvcResult trackResult = mockMvc.perform(MockMvcRequestBuilders
            .post("/Track/Agregar")
            .contentType(MediaType.APPLICATION_JSON)
            .content(trackJsonPayload))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

    // Extract the track ID from the response
    ObjectMapper objectMapper2 = new ObjectMapper();
JsonNode trackNode = objectMapper2.readTree(trackResult.getResponse().getContentAsString());

// Extract the track ID from the JSON response
long trackId = trackNode.get("track_id").asLong(); 
    // Step 3: Delete the track
    mockMvc.perform(MockMvcRequestBuilders
            .delete("/Track/Borrar/" + trackId)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testListar() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/Track/Lista")
        )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
*/
    
}
