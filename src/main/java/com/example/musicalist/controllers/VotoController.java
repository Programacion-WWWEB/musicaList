package com.example.musicalist.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicalist.DTOs.TrackDTO;
import com.example.musicalist.DTOs.UsuarioVotanteDTO;
import com.example.musicalist.DTOs.VotoDTO;
import com.example.musicalist.modelo.Track;
import com.example.musicalist.modelo.UsuarioVotante;
import com.example.musicalist.modelo.Voto;
import com.example.musicalist.respositories.TrackRepository;
import com.example.musicalist.respositories.UsuarioVotanteRepository;
import com.example.musicalist.services.VotoService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
@RestController
@RequestMapping("/Voto")
public class VotoController {

    @Autowired
    VotoService votoService;

    @Autowired
    UsuarioVotanteRepository usuarioVotanteRepository;

    @Autowired
    TrackRepository trackRepository;

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @PostMapping("/AgregarClick")
    public ResponseEntity<Voto> insertar(@RequestBody TrackDTO trackDTO, @RequestHeader("Authorization") String token){

         System.out.println("Received Token: " + token);

    String[] parts = token.split("\\.");
    DecodeTokenController decodeTokenController = new DecodeTokenController();
    String decodedPayload = decodeTokenController.decodeBase64(parts[1]);
    System.out.println(decodedPayload);

    String secretKey = "daf66e01593f61a15b857cf433aae03a005812b31234e149036bcc8dee755dbb";

    try {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();

        System.out.println("Subject: " + claims.getSubject());
        System.out.println("Issued At: " + claims.getIssuedAt());
        System.out.println("Expiration: " + claims.getExpiration());

        String username = (String) claims.get("username");
        String password = (String) claims.get("password");

        Optional<UsuarioVotante> userOptional = usuarioVotanteRepository.findUserByNombrePerfilAndContrasena(username, password);

        if (userOptional.isPresent()) {
            UsuarioVotante usuarioVotante = userOptional.get();
            UsuarioVotanteDTO usuarioVotanteDTO = new UsuarioVotanteDTO();

            // ... (populate usuarioVotanteDTO)

            VotoDTO votoDTO = new VotoDTO();
            votoDTO.setId(usuarioVotanteDTO.getId());
            votoDTO.setTrack_id(trackDTO.getTrack_id());
            votoDTO.setUsuarioVotante(usuarioVotante);

            Optional<Track> trackOptional = trackRepository.findById(trackDTO.getTrack_id());

            if (trackOptional.isPresent()) {
                votoDTO.setTrack(trackOptional.get());
                Voto result = votoService.insertar(votoDTO);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    } catch (JwtException ex) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    
    
    }

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @PostMapping("/Agregar")
    public Voto insertar(@RequestBody VotoDTO votoDTO){
        return votoService.insertar(votoDTO);
    
    
    }

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping("/Lista")
    public List<VotoDTO> lista(){
        return votoService.listar();

    }
}
