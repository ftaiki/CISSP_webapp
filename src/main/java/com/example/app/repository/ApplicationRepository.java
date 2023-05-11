package com.example.app.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.app.model.*;

@Repository
public class ApplicationRepository {
    
    @Autowired
    JdbcTemplate jdbc;

    //Questionテーブルを１件取得=>domain1のquestion.1みたいな感じで画面に渡す
    //これは全問やる時の機構かな？domainごとにやる時はまた別のメソッド呼ぶべきかも
    public List<Question> selectQuestionOne(String questionId) throws DataAccessException{

        //問題文1件取得
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM questions WHERE question_id = ?", questionId);
        Question question = new Question();

        System.out.println(questionId);
        question.setQuestionId((int) map.get("question_id"));
        question.setDomainId((int) map.get("domain_id"));
        question.setQuestion((String) map.get("question"));

        List<Question> list = new ArrayList<Question>();
        list.add(question);

        System.out.println(question);

        return list;
    }
    //選択肢を1件取得
    public List<Selection> selectAbcdOne(String questionId) throws DataAccessException{

        //問題文1件取得
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM selections WHERE question_id = ?", questionId);
        Selection selection = new Selection();

        selection.setQuestionId((int) map.get("question_id"));
        selection.setA((String) map.get("a"));
        selection.setB((String) map.get("b"));
        selection.setC((String) map.get("c"));
        selection.setD((String) map.get("d"));

        List<Selection> list = new ArrayList<Selection>();
        list.add(selection);

        return list;
    }
    public List<Answer> selectExplanationOne(String questionId) throws DataAccessException{

        //問題文1件取得
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM answers WHERE question_id = ?", questionId);
        Answer answer = new Answer();

        answer.setQuestionId((int) map.get("question_id"));  
        answer.setAnswer((String) map.get("answer"));
        answer.setExplanation((String) map.get("explanation"));
        List<Answer> list = new ArrayList<Answer>();
        
        list.add(answer);
        return list;
    }

}
