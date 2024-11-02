package com.example.questionare.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String response;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
