package com.example.OnlineQuiz_JPA.Dao;

import com.example.OnlineQuiz_JPA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
}
