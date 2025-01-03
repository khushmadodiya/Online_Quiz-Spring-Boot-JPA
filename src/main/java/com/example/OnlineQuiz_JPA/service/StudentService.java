package com.example.OnlineQuiz_JPA.service;
import com.example.OnlineQuiz_JPA.Dao.FacultyRepository;
import com.example.OnlineQuiz_JPA.Dao.QuestionRepository;
import com.example.OnlineQuiz_JPA.Dao.QuizRepository;
import com.example.OnlineQuiz_JPA.Dao.StudentRepossitory;
import com.example.OnlineQuiz_JPA.model.Faculty;
import com.example.OnlineQuiz_JPA.model.Quiz;
import com.example.OnlineQuiz_JPA.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentService {

    @Autowired
    StudentRepossitory studentRepossitory;
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    QuestionRepository questionRepository;

    public  String  save(Student student){
      try {
          Student student1  =  studentRepossitory.save(student);
          return  "success";
      }catch (Exception e){
          e.getMessage();
          return "Failed to save";
      }

    }
    public Student getStudentWithId(String id){
        Optional<Student> optional = studentRepossitory.findById(id);
        return optional.get();
    }



   public List<Quiz> findListOfQuizzesbyStudent(String studentId){
          List<Quiz>quizList=  quizRepository.findByStudent_Uid(studentId);
//          quizList.forEach(quiz -> {
//              System.out.println(quiz.getQuizTitle());;
//          });
          return  quizList;

    }

    public Faculty getFacultyWithId(String facultyId){
      Optional<Faculty>faculty =facultyRepository.findById(facultyId);
      return  faculty.get();
    }

    public Integer getNoOfQuestionInQuizByQuizId(String quizId) {
      return questionRepository.countByQuizQuizId(quizId);
    }


}
