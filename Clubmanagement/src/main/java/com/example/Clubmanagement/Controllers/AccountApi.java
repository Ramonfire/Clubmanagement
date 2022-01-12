package com.example.Clubmanagement.Controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.entities.compte.generlAc.Role;
import com.example.Clubmanagement.services.AccountService;
import com.example.Clubmanagement.services.EtudiantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = ("Clubpage"))
@RequiredArgsConstructor
public class AccountApi {

private final AccountService accountService;

    //*************************************************************************get mapping token refresh *************************************************************************************************//
    @GetMapping( path = "refreshtoken")
    public void refreshingtoken (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorisationHeader =request.getHeader(AUTHORIZATION);

        if (authorisationHeader!=null && authorisationHeader.startsWith("Bearer ")){
            try {
                String refresh_Token =authorisationHeader.substring("Bearer ".length());
                Algorithm algorithm =Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT =verifier.verify(refresh_Token);
                String email =decodedJWT.getSubject();
                Compte user= accountService.getAccountbymail(email);
                String access_Token = JWT.create()
                        .withSubject(user.getEmail()).
                        withExpiresAt(new Date(System.currentTimeMillis()+ 60*60*1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles",user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String,String> Tokens =new HashMap<>();
                Tokens.put("acces_token",access_Token);
                Tokens.put("refresh_token",refresh_Token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),Tokens);
            }catch (Exception exception){
                response.setHeader("error in {}", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());
                Map<String,String> error =new HashMap<>();
                error.put("error_message",exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);


                new ObjectMapper().writeValue(response.getOutputStream(),error);
            }


        }else throw new  RuntimeException("Refresh Token ismissing");



    }

    @SneakyThrows
    @GetMapping("info")
    public Compte getAccount(){
        return accountService.getaccoutThroughheader();
    }

}
