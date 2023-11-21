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
@Transactional
public class VotoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testVotoAgregar() throws Exception{

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

    // Step 2: Create a track using the album ID
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
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

            ObjectMapper objectMapper2 = new ObjectMapper();
    JsonNode trackNode = objectMapper2.readTree(trackResult.getResponse().getContentAsString());
    long trackId = trackNode.get("track_id").asLong();

    String usuarioVotanteJsonPayload = "{\n" +
        
        "    \"nombre\": \"usuario\",\n" +
        "    \"correo\": \"frde@ase\",\n" +
        "    \"contrasena\": \"password\",\n" +
        "    \"nombrePerfil\": \"usuarioPerfil\"\n" +

        "}";


MvcResult usuarioVotanteResult = mockMvc.perform(MockMvcRequestBuilders
        .post("/UsuarioVotante/Agregar")
        .contentType(MediaType.APPLICATION_JSON)
        .content(usuarioVotanteJsonPayload))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andReturn();

          ObjectMapper objectMapper3 = new ObjectMapper();
    JsonNode userNode = objectMapper3.readTree(usuarioVotanteResult.getResponse().getContentAsString());
    long userId = userNode.get("id").asLong();

    String votoJsonPayload = "{\n" +
    "    \"id\":" + userId + ",\n" +
    "    \"track_id\": " + trackId + ",\n" +
    "    \"usuarioVotante\": {\n" +
    "        \"id\": " + userId + ",\n" +
    "        \"nombre\": \"usuario\"\n" +
    "    },\n" +
    "    \"track\": {\n" +
    "        \"track_id\": " + trackId + ",\n" +
    "        \"title\": \"Un monde nouveau\"\n" +
    "    }\n" +
    "}";

mockMvc.perform(MockMvcRequestBuilders
    .post("/Voto/Agregar")
    .contentType(MediaType.APPLICATION_JSON)
    .content(votoJsonPayload))
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
