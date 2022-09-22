package com.portfolio.back.controller;

import com.portfolio.back.dto.AuthRequestDTO;
import com.portfolio.back.dto.AuthResponseDTO;
import com.portfolio.back.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.back.model.User;
import com.portfolio.back.security.JwtTokenUtil;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired 
    AuthenticationManager authManager;
    
    @Autowired 
    JwtTokenUtil jwtUtil;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO authRequestDTO) {
        try {
            String username = authRequestDTO.getUsername();
            String pass = authRequestDTO.getPassword();
            Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    username, pass));
      
            User user = (User) authentication.getPrincipal();

            String accessToken = jwtUtil.generateAccessToken(user);
            Person person = user.getPerson();
            AuthResponseDTO response = new AuthResponseDTO(user.getUsername(),
                accessToken, person.getId());
            
            return new ResponseEntity<>(response,HttpStatus.OK);
             
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
