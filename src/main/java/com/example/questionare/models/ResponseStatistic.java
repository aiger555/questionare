package com.example.questionare.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseStatistic {
    private String responseText;
    private Long count;
}
