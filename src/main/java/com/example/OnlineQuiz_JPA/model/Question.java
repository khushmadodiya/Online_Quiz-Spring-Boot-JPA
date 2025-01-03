package com.example.OnlineQuiz_JPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Question {
    @Id
    String questionId;
    String questionName;
    String option1;
    String option2;
    String option3;
    String option4;
    String ans;
    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "quiz_id", nullable = false)
    private Quiz quiz;


    public Question(String questionId,Quiz quiz, String ans, String option4, String option3, String option2, String option1, String questionName) {
        this.quiz = quiz;
        this.ans = ans;
        this.option4 = option4;
        this.option3 = option3;
        this.option2 = option2;
        this.option1 = option1;
        this.questionName = questionName;
        this.questionId = questionId;
    }
    public  Question(){}

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
