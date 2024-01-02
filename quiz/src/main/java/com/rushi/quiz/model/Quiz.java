package com.rushi.quiz.model;

//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;

import java.util.List;


@Data
public class Quiz{
    
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    // mongo db automatically generated unique values for object and integer //this annotation is for relational db to generate unique values



//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Integer id;
    private String title;
    @ManyToMany
    private List<Question> questions;


    public Quiz(Integer id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }
    public Quiz() {
        
    }
    

    public String getTitle() {
        return title;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}




//    private Integer id;

//if we want to conveert integer to string as mongo private key is mainly maintained with object id or string
// need to use custom convertor which internally check before interaction with mongodb and converts integer to string (IntegertoString)


//    import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.convert.ReadingConverter;
//import org.springframework.stereotype.Component;
//
//    @Component
//    @ReadingConverter
//    public class IntegerToObjectIdConverter implements Converter<Integer, String> {
//
//        @Override
//        public String convert(Integer source) {
//            // Convert Integer to String or use another appropriate method to represent it
//            return String.valueOf(source);
//        }
//    }



//
//
//    import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
//
//import java.util.Arrays;
//
//    @Configuration
//    public class MongoConfig {
//
//        @Bean
//        public MongoCustomConversions customConversions() {
//            return new MongoCustomConversions(Arrays.asList(new IntegerToObjectIdConverter()));
//        }
//    }



//
//    @Document(collection = "quizzes")
//    public class Quiz {
//        @Id
//        private Integer id;
//        // Other fields and methods
//    }
//
