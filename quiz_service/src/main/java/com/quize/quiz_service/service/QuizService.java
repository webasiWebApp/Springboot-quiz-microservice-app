package com.quize.quiz_service.service;

import com.quize.quiz_service.dto.QuizDto;
import com.quize.quiz_service.entity.QuestionWrapper;
import com.quize.quiz_service.entity.Quiz;

import com.quize.quiz_service.entity.Response;
import com.quize.quiz_service.feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import java.util.List;


@Service
public class QuizService {

    @Autowired
    QuizDto quizDto;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions = quizInterface.getQuestionForQuiz(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);
        quizDto.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public List<QuestionWrapper> getQuizQuestions(Integer id) {
        Quiz quiz = quizDto.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionsIds();
        List<QuestionWrapper> questions = quizInterface.getQuestionFromId(questionIds);
        return questions;

    }

    public Integer calculateResult(Integer id, List<Response> responses) {
        Integer score = quizInterface.getScore(responses);
        return score;
    }
}