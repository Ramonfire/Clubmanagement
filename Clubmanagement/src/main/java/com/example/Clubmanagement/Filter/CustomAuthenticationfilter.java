package com.example.Clubmanagement.Filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class CustomAuthenticationfilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public CustomAuthenticationfilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String email=request.getParameter("email");
        String password = request.getParameter("password");
        log.info("User name is :{} and password is {}",email,password);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,password);
        return  authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        User user =(User)authentication.getPrincipal();
        //secret is super important ! ust secure!.
        Algorithm algorithm =Algorithm.HMAC256("secret".getBytes(StandardCharsets.UTF_8));
        String access_Token = JWT.create()
                .withSubject(user.getUsername()).
                withExpiresAt(new Date(System.currentTimeMillis()+ 60*60*1000))//to make it 1 h later.
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles",user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);

        String refresh_Token = JWT.create()
                .withSubject(user.getUsername()).
                withExpiresAt(new Date(System.currentTimeMillis()+ 5*24*60*60*1000))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);

       /* response.setHeader("acces_token",access_Token);
        response.setHeader("refresh_token",refresh_Token);*/

        Map<String,String> Tokens =new HashMap<>();
        Tokens.put("acces_token",access_Token);
        Tokens.put("refresh_token",refresh_Token);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(),Tokens);
    }
}
