package com.example.OnlineQuiz_JPA.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @Column(name = "quiz_id", nullable = false, unique = true)
    private String quizId;

    @Column(name = "quiz_title", nullable = false)
    private String quizTitle;

    @Column(name = "sub_name", nullable = false)
    private String subName;

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "uid", nullable = false)
    private Faculty faculty;

    // Constructors
    public Quiz(String quizId, String quizTitle, String subName, Faculty faculty) {
        this.quizId = quizId;
        this.quizTitle = quizTitle;
        this.subName = subName;
        this.faculty = faculty;
    }

    public Quiz() {}

    // Getters and Setters
    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
