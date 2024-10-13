package com.example.questionare.controllers;

import com.example.questionare.models.Question;
import com.example.questionare.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("update/{id}")
    public String updateQuestion(@PathVariable Integer id, @RequestBody Question question){
        // Find the existing question by ID
        Question existingq = questionService.getQuestionById(id);

        //Update the fields
        existingq.setCategory(question.getCategory());
        existingq.setQuestion_title(question.getQuestion_title());
        existingq.setOption1(question.getOption1());
        existingq.setOption2(question.getOption2());
        existingq.setOption3(question.getOption3());


        //Save the updated question
        return questionService.updateQuestion(existingq);
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable Integer id){
        return questionService.delete(id);
    }
}
