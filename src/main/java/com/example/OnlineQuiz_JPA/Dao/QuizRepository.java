package com.example.OnlineQuiz_JPA.Dao;

import com.example.OnlineQuiz_JPA.model.Quiz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepository extends CrudRepository<Quiz,String > {
    List<Quiz> findByFaculty_Uid(String facultyId);
    @Query("SELECT q FROM Quiz q JOIN Marks m ON m.quiz.quizId = q.quizId WHERE m.student.uid = :studentId")
    List<Quiz> findByStudent_Uid(@Param("studentId") String studentId);

}
