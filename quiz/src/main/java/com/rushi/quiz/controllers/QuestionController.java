package com.rushi.quiz.controllers;

import com.rushi.quiz.model.Question;
import com.rushi.quiz.services.QuestoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/questions")

public class QuestionController {
    @Autowired
    QuestoinService questoinService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> allQuestions(){
        return questoinService.allQuestionsService();

    }

    @GetMapping("category/{category}")
    public ResponseEntity< List<Question>> getQuestionsByCategory(@PathVariable String category){
       return questoinService.getQuestionsByCtegory(category);

    }

    @PostMapping("/add")
    public ResponseEntity<List<Question>>  addQuestion(@RequestBody Question question){
        return questoinService.addQuestion(question);
    }







}
