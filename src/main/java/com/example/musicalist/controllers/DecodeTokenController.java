package com.example.musicalist.controllers;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicalist.DTOs.UsuarioVotanteDTO;
import com.example.musicalist.modelo.UsuarioVotante;
import com.example.musicalist.respositories.UsuarioVotanteRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


@RestController
@Component
public class DecodeTokenController {

    @Autowired
     UsuarioVotanteRepository usuarioVotanteRepository;

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @PostMapping(value = "/public/tokenUser")
    public ResponseEntity<Map<String, String>> decodeToken(@RequestBody String token){

        
        System.out.println("Received Token: " + token);

        String[] parts = token.split("\\.");

        // Decode and display the payload
        String decodedPayload = decodeBase64(parts[1]);
        System.out.println(decodedPayload);

          String secretKey = "daf66e01593f61a15b857cf433aae03a005812b31234e149036bcc8dee755dbb";

          Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();


System.out.println("Subject: " + claims.getSubject());
System.out.println("Issued At: " + claims.getIssuedAt());
System.out.println("Expiration: " + claims.getExpiration());

// Access custom claims
String username = (String) claims.get("username");
String password = (String) claims.get("password");

System.out.println("Username: " + username);
System.out.println("Password: " + password);


    Optional<UsuarioVotante> userOptional = usuarioVotanteRepository.findUserByNombrePerfilAndContrasena(username, password);

        if (userOptional.isPresent()) {

            UsuarioVotante usuarioVotante = userOptional.get();

            UsuarioVotanteDTO usuarioVotanteDTO = new UsuarioVotanteDTO();

            usuarioVotanteDTO.setNombre(usuarioVotante.getNombre());
            usuarioVotanteDTO.setCorreo(usuarioVotante.getCorreo());
            usuarioVotanteDTO.setNombrePerfil(usuarioVotante.getNombrePerfil());

            
            
            Map<String, String> response = new HashMap<>();
            response.put("nombre", usuarioVotanteDTO.getNombre());
            response.put("nombre del perfil", usuarioVotanteDTO.getNombrePerfil());
            response.put("correo", usuarioVotanteDTO.getCorreo());

            return ResponseEntity.ok(response);
        } else {
            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    

    private static String decodeBase64(String base64) {
        
        String base64Padded = base64 + "==".substring(0, (4 - base64.length() % 4) % 4);
        byte[] decodedBytes = Base64.getUrlDecoder().decode(base64Padded);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
}
