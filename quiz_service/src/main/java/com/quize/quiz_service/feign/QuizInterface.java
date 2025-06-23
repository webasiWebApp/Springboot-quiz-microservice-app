package com.quize.quiz_service.feign;


import com.quize.quiz_service.entity.QuestionWrapper;
import com.quize.quiz_service.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("question-service")
public interface QuizInterface {

    @GetMapping("/question/generate")
    public List<Integer> getQuestionForQuiz(@RequestParam String categoryName , @RequestParam Integer noq);

    @PostMapping("/question//getQuestion")
    public List<QuestionWrapper> getQuestionFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("/question/getScore")
    public Integer getScore(@RequestBody List<Response> responses);

}
