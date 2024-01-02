package com.rushi.quiz.services;
import com.rushi.quiz.model.QuestionWrapper;
import com.rushi.quiz.constants.Constants;
import com.rushi.quiz.dao.QuestionDao;
import com.rushi.quiz.dao.QuizDao;
import com.rushi.quiz.model.Question;
import com.rushi.quiz.model.Quiz;
import com.rushi.quiz.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<Quiz> createQuiz(String category, int numQ, String title) {
        List<Question> questions =questionDao.findRandomQuestionByCategory(category,numQ,title);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setId(Constants.primaryKey());
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>(quiz,HttpStatus.OK);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz=quizDao.findById(id);

        List<Question> questionsFromDb=quiz.get().getQuestions();
        List<QuestionWrapper> questionsfromUser = new ArrayList<>();
        for(Question q:questionsFromDb){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsfromUser.add(qw);
        }

        return new ResponseEntity<>(questionsfromUser,HttpStatus.OK);



    }

    public ResponseEntity<Integer> submitQuiz(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int correctResponses = 0;
        int iterOverQuestions = 0;
        for (Response response : responses) {
            if(response.getResponse().equals(questions.get(iterOverQuestions).getRightAnswer())) {
                correctResponses += 1;
            }
            iterOverQuestions += 1;
        }
        return new ResponseEntity<>(correctResponses,HttpStatus.OK);
    }
}
