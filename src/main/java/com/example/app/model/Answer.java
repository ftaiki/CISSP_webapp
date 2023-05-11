package com.example.app.model;

import lombok.Data;

@Data
public class Answer {
    private int questionId;
    private String answer;
    private String explanation;
}
