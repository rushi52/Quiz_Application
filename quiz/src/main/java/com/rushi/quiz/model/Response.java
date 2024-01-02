package com.rushi.quiz.model;

import lombok.Data;

@Data
public class Response {
    private String id;
    private String response;

    public Response(String id, String response) {
        this.id = id;
        this.response = response;
    }
}
