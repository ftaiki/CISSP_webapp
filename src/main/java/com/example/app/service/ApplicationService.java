package com.example.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Selection;
import com.example.app.model.Answer;
import com.example.app.model.Question;
import com.example.app.repository.ApplicationRepository;

@Service
public class ApplicationService{
    
    @Autowired
    ApplicationRepository applicationRepository;

    public List<Question> selectOne(String questionId){

        List<Question> list = new ArrayList<Question>();

        list = applicationRepository.selectQuestionOne(questionId);

        System.out.println(list);
        return list;
    }


    public List<Selection> selectAbcdOne(String questionId){

        List<Selection> list = new ArrayList<Selection>();

        list = applicationRepository.selectAbcdOne(questionId);

        return list;
    }

    public List<Answer> selectExplanationOne(String questionId){

        List<Answer> list = new ArrayList<Answer>();

        list = applicationRepository.selectExplanationOne(questionId);

        return list;
    }
}
