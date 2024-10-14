package com.example.questionare.services;

import com.example.questionare.dao.QDao;
import com.example.questionare.dao.QuestionDao;
import com.example.questionare.models.Q;
import com.example.questionare.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QService {
    @Autowired
    QDao qDao;
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQ(String category, int numQ, String title) {

        List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);

        Q q = new Q();
        q.setTitle(title);
        q.setQuestions(questions);
        qDao.save(q);

        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }
}
