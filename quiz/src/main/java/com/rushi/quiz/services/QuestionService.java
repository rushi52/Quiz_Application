package com.rushi.quiz.services;

import com.rushi.quiz.dao.QuestionDao;
import com.rushi.quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getQuestionsByCtegory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);


    }


    public ResponseEntity<List<Question>> allQuestionsService() {
        //return Collections.singletonList((Question) questionDao.findAll());
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> addQuestion(Question question) {

        questionDao.save(question);
        try {
            return new ResponseEntity<>(questionDao.findAll(),HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);


    }
}
