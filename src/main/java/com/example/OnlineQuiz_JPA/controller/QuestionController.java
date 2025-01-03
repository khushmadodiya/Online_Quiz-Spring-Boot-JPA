package com.example.OnlineQuiz_JPA.controller;
import com.example.OnlineQuiz_JPA.model.Question;
import com.example.OnlineQuiz_JPA.model.Quiz;
import com.example.OnlineQuiz_JPA.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @PostMapping("/question")
    ResponseEntity<String> addQuestionToQuiz(@RequestBody Map<String, Object> request) {
        try {
            String quizId = (String) request.get("quizId");

            Question question = new Question();
            question.setQuestionId((String) request.get("questionId"));
            question.setQuestionName((String) request.get("questionName"));
            question.setOption1((String) request.get("option1"));
            question.setOption2((String) request.get("option2"));
            question.setOption3((String) request.get("option3"));
            question.setOption4((String) request.get("option4"));
            question.setAns((String) request.get("ans"));

            questionService.createQuestion(question,quizId);
            return ResponseEntity.ok("Question added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/question/{quizId}")
    ResponseEntity<List<Question>>fetchAllQuestionByQuizId(@PathVariable("quizId") String quizId){
        List<Question>list= questionService.fetchAllQuestionsByQuizId(quizId);
        if (list.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @PutMapping("/question")
    ResponseEntity<String> updateQuestion(@RequestBody Question question){
        try {
            return  ResponseEntity.of(Optional.of(questionService.updateQuestion(question)));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/question/{questionId}")
    ResponseEntity<String> deleteQuestion(@PathVariable("questionId") String questionId){
        try {
            return  ResponseEntity.of(Optional.of(questionService.deleteQuestion(questionId)));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
