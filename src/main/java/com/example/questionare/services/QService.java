package com.example.questionare.services;

import com.example.questionare.dao.QDao;
import com.example.questionare.dao.QuestionDao;
import com.example.questionare.dao.ResponseDao;
import com.example.questionare.models.*;
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
    @Autowired
    ResponseDao responseDao;


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


    public ResponseEntity<String> save(List<Response> responses) {
        for (Response response: responses) {
            responseDao.save(response);
        }
        return new ResponseEntity<>("Response has been saved successfully", HttpStatus.CREATED);
    }


    public ResponseEntity<List<ResponseStatistic>> getResponseStatistics(Integer questionId) {
        List<Object[]> results = responseDao.findResponseStatisticsByQuestionId(questionId);
        List<ResponseStatistic> statistics = new ArrayList<>();

        for (Object[] result : results) {
            String responseText = (String) result[0];
            Long count = (Long) result[1];
            statistics.add(new ResponseStatistic(responseText, count));
        }
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

}
