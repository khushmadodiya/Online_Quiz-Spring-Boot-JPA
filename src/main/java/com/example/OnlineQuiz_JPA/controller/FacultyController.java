package com.example.OnlineQuiz_JPA.controller;

import com.example.OnlineQuiz_JPA.model.Faculty;
import com.example.OnlineQuiz_JPA.model.Marks;
import com.example.OnlineQuiz_JPA.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class FacultyController {
    @Autowired
    FacultyService facultyService;



    @GetMapping("faculty/{id}")
    ResponseEntity<Faculty> getFacultyWithId(@PathVariable("id") String id){
        try {
            Faculty faculty= facultyService.getFacultyWithId(id);
            return  ResponseEntity.status(HttpStatus.OK).body(faculty);
        }catch (Exception e){
            e.getMessage();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @PostMapping("/faculty")
    public String saveStudent(@RequestBody Faculty faculty){
        System.out.println(faculty.getUid());
        String res = facultyService.save(faculty);
        return  res;
    }
    @GetMapping("faculty/marksList/{quizId}")
    public List<Marks> getAllStudentwithQuiz(@PathVariable("quizId") String quizId){
        return facultyService.getMarksOfAllStudentWithQuizId(quizId);
    }

}
