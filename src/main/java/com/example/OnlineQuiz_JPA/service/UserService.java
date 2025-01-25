package com.example.OnlineQuiz_JPA.service;

import com.example.OnlineQuiz_JPA.Dao.UserRepo;
import com.example.OnlineQuiz_JPA.model.User;
import com.example.OnlineQuiz_JPA.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo repo;
    @Autowired
    AuthenticationManager manager;
    @Autowired
    JWTService jwtService;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    public  User save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public String verify(User user) {
        System.out.println("helo");
        System.out.println(user.getPassword()+" "+user.getUsername());
        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        System.out.println(user.getPassword()+" "+user.getUsername());
        if(authentication.isAuthenticated()){
           return jwtService.getToken(user.getUsername());
//            return  "success";
        }
        return "failed";
    }
}

