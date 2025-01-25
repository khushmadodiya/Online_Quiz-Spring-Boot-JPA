package com.example.OnlineQuiz_JPA.service;
import com.example.OnlineQuiz_JPA.Dao.QuestionRepository;
import com.example.OnlineQuiz_JPA.Dao.QuizRepository;
import com.example.OnlineQuiz_JPA.model.Question;
import com.example.OnlineQuiz_JPA.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    JdbcTemplate template;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuizRepository quizRepository;

    public Question createQuestion(Question question,String quizId){

        Optional<Quiz> quiz = quizRepository.findById(quizId);
        Quiz quiz1 = quiz.get();
        question.setQuiz(quiz1);
      return  questionRepository.save(question);
    }

    public String updateQuestion(Question question){
        Optional<Question>question1 = questionRepository.findById(question.getQuestionId());
        Question question2 = question1.get();
        question2.setQuestionName(question.getQuestionName());
        question2.setOption1(question.getOption1());
        question2.setOption2(question.getOption2());
        question2.setOption3(question.getOption3());
        question2.setOption4(question.getOption4());
        question2.setAns(question.getAns());
        questionRepository.save(question2);
        return  "success";
    }

    public String deleteQuestion(String questionId){
        Optional<Question> question = questionRepository.findById(questionId);
        Question question1 = question.get();
        questionRepository.delete(question1);
        return  "success";
    }

    public List<Question> fetchAllQuestionsByQuizId(String quizId) {
      return questionRepository.findByQuizQuizId(quizId);
    }
}
