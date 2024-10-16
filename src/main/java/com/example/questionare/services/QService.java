package com.example.questionare.services;

import com.example.questionare.dao.QDao;
import com.example.questionare.dao.QuestionDao;
import com.example.questionare.models.Q;
import com.example.questionare.models.Question;
import com.example.questionare.models.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public ResponseEntity<List<QuestionWrapper>> getQquestions(Integer id) {
        Optional<Q> q = qDao.findById(id);
        List<Question> questionsFromDB = q.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(Question qs : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(
                    qs.getId(),
                    qs.getQuestion_title(),
                    qs.getOption1(),
                    qs.getOption2(),
                    qs.getOption3());
            questionsForUser.add(qw);


        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }
}
