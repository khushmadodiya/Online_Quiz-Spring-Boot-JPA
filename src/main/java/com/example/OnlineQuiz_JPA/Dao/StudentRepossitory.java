package com.example.OnlineQuiz_JPA.Dao;

import com.example.OnlineQuiz_JPA.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepossitory extends CrudRepository<Student,String> {
    
}
