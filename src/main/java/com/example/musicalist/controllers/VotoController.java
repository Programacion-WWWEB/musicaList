package com.example.musicalist.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicalist.DTOs.TrackDTO;
import com.example.musicalist.DTOs.UsuarioVotanteDTO;
import com.example.musicalist.DTOs.VotoDTO;
import com.example.musicalist.modelo.Track;
import com.example.musicalist.modelo.UsuarioVotante;
import com.example.musicalist.modelo.Voto;
import com.example.musicalist.respositories.TrackRepository;
import com.example.musicalist.respositories.UsuarioVotanteRepository;
import com.example.musicalist.respositories.VotoRepository;
import com.example.musicalist.services.VotoService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/Voto")
public class VotoController {

    @Autowired
    VotoService votoService;

    @Autowired
    VotoRepository votoRepository;

    @Autowired
    UsuarioVotanteRepository usuarioVotanteRepository;

    @Autowired
    TrackRepository trackRepository;

    
    @PostMapping("/AgregarClick")
    public ResponseEntity<Voto> insertar(@RequestBody TrackDTO trackDTO, @RequestHeader("Authorization") String token){

         System.out.println("Received Token: " + token);

    String[] parts = token.split("\\.");
    DecodeTokenController decodeTokenController = new DecodeTokenController();
    String decodedPayload = decodeTokenController.decodeBase64(parts[1]);
    System.out.println(decodedPayload);
    String tokenWithoutBearer = token.replace("Bearer ", "");
        System.out.println(token);
        System.out.println(tokenWithoutBearer);
    String secretKey = "daf66e01593f61a15b857cf433aae03a005812b31234e149036bcc8dee755dbb";
    System.out.println("Track title:" + trackDTO.getTitle());

    System.out.println("Track title:" + trackDTO.getTrack_id());
    try {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(tokenWithoutBearer).getBody();

        System.out.println("Subject: " + claims.getSubject());
        System.out.println("Issued At: " + claims.getIssuedAt());
        System.out.println("Expiration: " + claims.getExpiration());

        String username = (String) claims.get("username");
        String password = (String) claims.get("password");


        Optional<UsuarioVotante> userOptional = usuarioVotanteRepository.findUserByNombrePerfilAndContrasena(username, password);
       
        if (userOptional.isPresent()) {
            UsuarioVotante usuarioVotante = userOptional.get();
            UsuarioVotanteDTO usuarioVotanteDTO = new UsuarioVotanteDTO();

            Optional<Track> trackOptional = trackRepository.findById(trackDTO.getTrack_id());

            if (trackOptional.isPresent()) {
                System.out.println(trackDTO.getTitle());
        System.out.println(trackDTO.getTrack_id());
        System.out.println(usuarioVotante.getId());
        System.out.println(usuarioVotanteDTO.getId());
        System.out.println(trackOptional.get().getTrack_id());
                VotoDTO votoDTO = new VotoDTO();
            votoDTO.setId(usuarioVotante.getId());
            votoDTO.setTrack_id(trackDTO.getTrack_id());
            votoDTO.setUsuarioVotante(usuarioVotante);
                votoDTO.setTrack(trackOptional.get());
                Voto result = votoService.insertar(votoDTO);
                System.out.println(result);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                System.out.println("Bad Request");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            System.out.println("No autorizado");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    } catch (JwtException ex) {
        System.out.println(ex);
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    
    
    }

    
    @PostMapping("/Agregar")
    public Voto insertar(@RequestBody VotoDTO votoDTO, @RequestHeader("Authorization") String token){
        return votoService.insertar(votoDTO);
    
    
    }

    
    @GetMapping("/Lista")
    public List<VotoDTO> lista(@RequestHeader("Authorization") String token){
        return votoService.listar();

    }
    
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
@PostMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<?> checkVotoExistence(
        @RequestParam Long trackId,
        @RequestParam Long userId,
        @RequestHeader("Authorization") String token
) {
    List<Object[]> result = votoRepository.sqlFindById(trackId, userId);
    boolean exists = !result.isEmpty();

    
    Map<String, Object> response = new HashMap<>();
    response.put("result", exists);

    
    return ResponseEntity.ok(response);
}
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @DeleteMapping("/Borrar")
    public void eliminar(@RequestBody VotoDTO voto){

        votoService.eliminar(voto);

    }



}
