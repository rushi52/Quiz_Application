package com.rushi.quiz.controllers;

import com.rushi.quiz.model.Question;
import com.rushi.quiz.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/questions")

public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> allQuestions(){
        return questionService.allQuestionsService();

    }

    @GetMapping("category/{category}")
    public ResponseEntity< List<Question>> getQuestionsByCategory(@PathVariable String category){
       return questionService.getQuestionsByCtegory(category);

    }

    @PostMapping("/add")
    public ResponseEntity<List<Question>>  addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }







}
