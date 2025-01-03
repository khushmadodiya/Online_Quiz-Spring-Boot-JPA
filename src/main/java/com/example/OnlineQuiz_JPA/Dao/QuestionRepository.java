package com.example.OnlineQuiz_JPA.Dao;

import com.example.OnlineQuiz_JPA.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question,String > {
    List<Question> findByQuizQuizId(String quizId);
//
//    @Query("SELECT COUNT(q.quizId) FROM Question q WHERE q.quizId = :quizId")
    int countByQuizQuizId( String quizId);
}
