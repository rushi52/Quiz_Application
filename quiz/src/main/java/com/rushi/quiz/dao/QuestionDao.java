package com.rushi.quiz.dao;

import com.rushi.quiz.model.Question;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionDao extends MongoRepository<Question,Integer> {

    List<Question> findByCategory(String category);

    @Aggregation(pipeline = {
            "{ $match: { category : ?0 } }",
            "{ $sample: { size: ?1 } }"
    })
    List<Question> findRandomQuestionByCategory(String category, int numQ, String title);
}
