package com.example.questionare.services;

import com.example.questionare.dao.QuestionDao;
import com.example.questionare.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>>getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }

    public String updateQuestion(Question question) {
        questionDao.save(question);
        return "updated";
    }

    public String delete(Integer id) {
        questionDao.deleteById(id);
        return "deleted";
    }

    public Question getQuestionById(Integer id) {
        return questionDao.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }
}
