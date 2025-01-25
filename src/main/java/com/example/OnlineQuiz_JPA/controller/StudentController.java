package com.example.OnlineQuiz_JPA.controller;

import com.example.OnlineQuiz_JPA.model.Marks;
import com.example.OnlineQuiz_JPA.model.Quiz;
import com.example.OnlineQuiz_JPA.model.Student;
import com.example.OnlineQuiz_JPA.service.MarksService;
import com.example.OnlineQuiz_JPA.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    MarksService marksService;

    @GetMapping("/")
    @ResponseBody
    String hello(HttpServletRequest http){
        return "hello Khushvant Madodiya jii"+http.getSession().getId();
    }
    @GetMapping("csrf")
    CsrfToken token(HttpServletRequest request){
      return (CsrfToken) request.getAttribute("_csrf");
    }
    @GetMapping("student")
    List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }


    @GetMapping("student/{id}")
    ResponseEntity<Student> getStudentWithId(@PathVariable("id") String id){
       try {
           Student student= studentService.getStudentWithId(id);
           return  ResponseEntity.status(HttpStatus.OK).body(student);
       }catch (Exception e){
           e.getMessage();
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }
    }
    @PostMapping("/student")
    public String saveStudent(@RequestBody Student student){
        System.out.println(student.getUid());
        String res = studentService.save(student);
        return  res;
    }

    @GetMapping("student/quiz/{studentId}")
    public List<Quiz> getQuizzesByStudentId(@PathVariable("studentId") String studentId){
        return  studentService.findListOfQuizzesbyStudent(studentId);
    }

    @PostMapping("student/quiz/submit")
    public  ResponseEntity<String>  submitQuiz(@RequestBody Map<String,Object> res){
        try {
            System.out.println(res);
            String status = (String) res.get("status");
            int marksObtained = (int)res.get("marksObtained");
            String quizId = (String) res.get("quizId");
            String studentId = (String) res.get("studentId");
            String marksob = Integer.toString(marksObtained);
            Marks marks = new Marks(marksob,status);
//            System.out.println("helloeelleolloelloe");
//            System.out.println(status);
//            System.out.println(marksObtained);
//            System.out.println(studentId + quizId + marksObtained + status);

            String response=  marksService.updateMarksOfStudent(marks,studentId,quizId);

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            e.getMessage();
            return   ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//             "Error inserting record: " + e.getMessage();
        }
//
    }

    @GetMapping("student/faculty/{facultyId}")
    public String getFacultyName(@PathVariable("facultyId") String facultyId){
        String name = studentService.getFacultyWithId(facultyId).getUsername();
        return  name;
    }

    @GetMapping("student/question/count/{quizId}")
    public  int getNoOfQuestionINQuiz(@PathVariable("quizId") String quizId){
        return  studentService.getNoOfQuestionInQuizByQuizId(quizId);
    }

}
