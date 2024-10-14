package com.example.questionare.controllers;

import com.example.questionare.services.QService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("questionare")
public class QController {

    @Autowired
    QService qService;

    @PostMapping("create")
    public ResponseEntity<String> createQ(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return qService.createQ(category, numQ, title);

    }
}
