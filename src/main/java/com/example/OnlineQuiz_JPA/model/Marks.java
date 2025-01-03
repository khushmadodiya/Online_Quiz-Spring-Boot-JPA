package com.example.OnlineQuiz_JPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Entity
public class Marks {
    @Id
    String marksId;
    String marksObtained;
    String  status;
    @ManyToOne
    @JoinColumn(name = "quizId", referencedColumnName = "quiz_id", nullable = false)
    private Quiz quiz;
    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "uid", nullable = false)
    private Student student;

    public Marks(String marksId) {
        this.marksId = marksId;

    }

    public Marks( String marksObtained, String status) {

        this.marksObtained = marksObtained;
        this.status = status;
    }

    public  Marks(){}



    public String getMarksId() {
        return marksId;
    }

    public void setMarksId(String marksId) {
        this.marksId = marksId;
    }

    public String getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(String marksObtained) {
        this.marksObtained = marksObtained;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
