package com.example.OnlineQuiz_JPA.config;

import com.example.OnlineQuiz_JPA.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtFileter extends OncePerRequestFilter {
    @Autowired
    private JWTService jwtService;
    @Autowired
    ApplicationContext context;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       String authHeader = request.getHeader("Authorization");
       String token = null;
       String username = null;
       if(authHeader != null && authHeader.startsWith("Bearer")){
           token = authHeader.substring(7);
           username = jwtService.extracktToken(token);
           if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
               UserDetails userDetails = context.getBean(UserDetails.class);
               if(jwtService.validate(token,userDetails)){}

           }
       }
    }
}
