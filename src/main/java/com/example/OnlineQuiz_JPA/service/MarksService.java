package com.example.OnlineQuiz_JPA.service;
import com.example.OnlineQuiz_JPA.Dao.MarksRepository;
import com.example.OnlineQuiz_JPA.Dao.QuizRepository;
import com.example.OnlineQuiz_JPA.Dao.StudentRepossitory;
import com.example.OnlineQuiz_JPA.model.Marks;
import com.example.OnlineQuiz_JPA.model.Quiz;
import com.example.OnlineQuiz_JPA.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Service
public class MarksService {
    @Autowired
    JdbcTemplate template;
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    StudentRepossitory studentRepossitory;
    @Autowired
    MarksRepository marksRepository;



    public String inserRecoderInMarks(Marks marks,String quizId,String studentId) {
        int count = marksRepository.countByQuiz_QuizIdAndStudent_Uid(quizId,studentId);
        System.out.println("this is count"+ count);
        if(count==0){
            Optional<Quiz> quiz = quizRepository.findById(quizId);
            if(quiz.isPresent()){
                Optional<Student> student = studentRepossitory.findById(studentId);
                if(student.isPresent()){
                    marks.setQuiz(quiz.get());
                    marks.setStudent(student.get());
                    marks.setStatus("0");
                    marks.setMarksObtained("0");
                    System.out.println(marks.getMarksId());
                    System.out.println(marks.getQuiz().getQuizId());
                    System.out.println(marks.getStudent().getUsername());
                    marksRepository.save(marks);
                    return "success";
                }
                else {
                    System.out.println("somthing wrong");
                    return  "Failed to join";
                }
            }
            else {
                System.out.println("Quiz not found I dont know how");
                return "Failed to join";
            }


        }
        else {
            System.out.println("Quiz is already Present");
            return  "Quiz is already Present";
        }

    }

    public String updateMarksOfStudent(Marks marks,String studentId,String quizId){


        Marks marks1=marksRepository.findByQuiz_QuizIdAndStudent_Uid(quizId,studentId);
        System.out.println("here is marks Id");
        System.out.println(marks1.getMarksId());
       marks1.setMarksObtained(marks.getMarksObtained());
       marks1.setStatus(marks.getStatus());
       marksRepository.save(marks1);
       return  "success";
    }

    public List<Marks> getMarksbystIdAndQuizId(String studentId){
       return  marksRepository.findByStudent_Uid(studentId);

    }

}
