package com.rushi.quiz.dao;

import com.rushi.quiz.model.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends MongoRepository<Quiz,Integer> {




}
