package com.example.questionare.models;

import jakarta.persistence.*;
import com.example.questionare.models.Question;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Q {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    private List<Question> questions;
}
