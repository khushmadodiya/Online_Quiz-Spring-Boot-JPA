package com.example.OnlineQuiz_JPA.controller;
import com.example.OnlineQuiz_JPA.model.Marks;
import com.example.OnlineQuiz_JPA.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
public class MarksController {
    @Autowired
    MarksService marksService;
    @PostMapping("/marks")
    public ResponseEntity<String> insertRecordInMarks(@RequestBody Map<String, Object> res) {
        try {
            System.out.println(res);
            String marksId = (String) res.get("marksId");
            String quizId = (String) res.get("quizId");
            String studentId = (String) res.get("studentId");


            Marks marks = new Marks(marksId);
           String responese=  marksService.inserRecoderInMarks(marks,quizId,studentId);

            return ResponseEntity.status(HttpStatus.OK).body(responese);
        } catch (Exception e) {
          return   ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//             "Error inserting record: " + e.getMessage();
        }
    }

    @GetMapping("/marks/{studentId}")
    List<Marks> getMarksOfstudent(@PathVariable("studentId") String studentId){
        List<Marks>list=  marksService.getMarksbystIdAndQuizId(studentId);
        System.out.println(list);
        return  list;
    }

}
