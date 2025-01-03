package com.example.OnlineQuiz_JPA.controller;
import com.example.OnlineQuiz_JPA.model.Quiz;
import com.example.OnlineQuiz_JPA.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class QuizController {
    @Autowired
    QuizService quizService;

//    @GetMapping("/quiz")
//    List<Quiz> show(){
//        List<Quiz> quizes= quizRepo.findAll();
//        return  quizes;
//    }

    @PostMapping("{facultyId}/quiz")
    public String saveQuiz(@RequestBody Quiz quiz, @PathVariable("facultyId") String facultyId){
        Quiz quiz1 = quizService.createQuiz(quiz,facultyId);
        System.out.println(quiz1);
        return  "success";
    }

    @GetMapping("/{facultyId}/quiz/list")
    public  List<Quiz> quizList(@PathVariable("facultyId") String id){
        System.out.println("This is faculty Id"+id);
        return  quizService.getQuizzesByFacultyId(id);
    }
    @DeleteMapping("/quiz/{id}")
    public  String deleteQuiz(@PathVariable("id") String quizId){
        String res = quizService.deleteQuiz(quizId);
        return  res;
    }

}
