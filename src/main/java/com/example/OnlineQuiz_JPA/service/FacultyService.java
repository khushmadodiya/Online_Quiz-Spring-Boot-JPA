package com.example.OnlineQuiz_JPA.service;
import com.example.OnlineQuiz_JPA.Dao.FacultyRepository;
import com.example.OnlineQuiz_JPA.Dao.MarksRepository;
import com.example.OnlineQuiz_JPA.model.Faculty;
import com.example.OnlineQuiz_JPA.model.Marks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    MarksRepository marksRepository;

    public  String  save(Faculty faculty){
        try {
            Faculty faculty1  = (Faculty) facultyRepository.save(faculty);
            return  "success";
        }catch (Exception e){
            e.getMessage();
            return "Failed to save";
        }

    }
    public Faculty getFacultyWithId(String id){
        Optional<Faculty> optional = facultyRepository.findById(id);
        return optional.get();
    }

    public List<Marks> getMarksOfAllStudentWithQuizId(String quizId){
        return  marksRepository.findByQuizQuizId(quizId);
    }
}
