package com.example.OnlineQuiz_JPA.service;

import com.example.OnlineQuiz_JPA.Dao.UserRepo;
import com.example.OnlineQuiz_JPA.model.User;
import com.example.OnlineQuiz_JPA.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findUserByUsername(username);
        if(user ==null){
            throw  new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }

    public  User save(User user){
       return repo.save(user);
    }
}
