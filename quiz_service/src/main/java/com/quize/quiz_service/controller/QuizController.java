package com.quize.quiz_service.controller;


import com.quize.quiz_service.entity.QuestionWrapper;
import com.quize.quiz_service.entity.QuizDao;
import com.quize.quiz_service.entity.Response;
import com.quize.quiz_service.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDao quizDao){
        return quizService.createQuiz( quizDao.getCategoryName(), quizDao.getNoq(), quizDao.getTitle());
    }

    @PostMapping("get/{id}")
    public List<QuestionWrapper> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public Integer submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }




}
