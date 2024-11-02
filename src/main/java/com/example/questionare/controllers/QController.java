package com.example.questionare.controllers;

import com.example.questionare.models.Question;
import com.example.questionare.models.QuestionWrapper;
import com.example.questionare.models.Response;
import com.example.questionare.models.ResponseStatistic;
import com.example.questionare.services.QService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questionare")
public class QController {

    @Autowired
    QService qService;

    @PostMapping("create")
    public ResponseEntity<String> createQ(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return qService.createQ(category, numQ, title);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQquestions(@PathVariable Integer id){
        return qService.getQquestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<String> submitQ(@PathVariable Integer id, @RequestBody List<Response> responses){
        return qService.save(responses);
    }

    @GetMapping("/statistics/{questionId}")
    public ResponseEntity<List<ResponseStatistic>> getResponseStatistics(@PathVariable Integer questionId){
        return qService.getResponseStatistics(questionId);
    }

}
