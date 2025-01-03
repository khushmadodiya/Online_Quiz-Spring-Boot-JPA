package com.example.OnlineQuiz_JPA.service;
import com.example.OnlineQuiz_JPA.Dao.FacultyRepository;
import com.example.OnlineQuiz_JPA.Dao.QuizRepository;
import com.example.OnlineQuiz_JPA.model.Faculty;
import com.example.OnlineQuiz_JPA.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class QuizService {

    JdbcTemplate template;
    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    FacultyService facultyService;


    public boolean isFacultyExist(String facultyId){
     try{
         Optional<Faculty> faculty =   facultyRepository.findById(facultyId);
         Faculty faculty1 =  faculty.get();
         if(!faculty1.getUsername().isEmpty()){
             return  true;
         }
         else {
             return false;
         }
     }catch (Exception e){
         return  false;
     }

    }


    public  Quiz  createQuiz(Quiz quiz,String facultyId){
      Faculty faculty= facultyService.getFacultyWithId(facultyId);;

        quiz.setFaculty(faculty);

        return  quizRepository.save(quiz);
    }

    public List<Quiz> getQuizzesByFacultyId(String facultyId) {
        return quizRepository.findByFaculty_Uid(facultyId);
    }


    public  String  deleteQuiz(String quizId){
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        Quiz quiz1 = quiz.get();
        quizRepository.delete(quiz1);
        return "success";
    }

}
