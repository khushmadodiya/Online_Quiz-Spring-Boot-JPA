package com.example.OnlineQuiz_JPA.Dao;

import com.example.OnlineQuiz_JPA.model.Marks;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MarksRepository extends CrudRepository<Marks,String> {
    List<Marks> findByStudent_Uid(String studentId);

    int countByQuiz_QuizIdAndStudent_Uid(String quizId, String studentId);

    Marks findByQuiz_QuizIdAndStudent_Uid(String quizId, String studentId);

    List<Marks> findByQuizQuizId(String quizId);
}
