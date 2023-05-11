package com.example.app.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.model.Selection;
import com.example.app.model.Answer;
import com.example.app.model.Question;
import com.example.app.repository.ApplicationRepository;
import com.example.app.service.ApplicationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ApplicationController{
    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    ApplicationService applicationService;

    @GetMapping("/")
    public String top(Model model){
        return "index";
    }
    //test用で、確定でdomain1のq1に飛ばすようにしている
    @GetMapping("/problem")
    public String problem(@RequestParam("questionId") String questionId, Model model){
        
        List<Question> questionlist = applicationService.selectOne(questionId);
        //TODO 選択肢をもってくる
        List<Selection> selectionList = applicationService.selectAbcdOne(questionId);

        //TODO 答えを持ってくる
        List<Answer> answerList = applicationService.selectExplanationOne(questionId);
        //TODO 解説を持ってくる
        model.addAttribute("questionList", questionlist.get(0));
        model.addAttribute("selectionList", selectionList.get(0));
        model.addAttribute("answerList", answerList.get(0));

        return "problem";
    }

}