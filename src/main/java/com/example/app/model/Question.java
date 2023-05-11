package com.example.app.model;

import lombok.Data;

@Data
public class Question {
    private int questionId;
    private int domainId;
    private String question;
}
