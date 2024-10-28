package com.example.questionare.dao;

import com.example.questionare.models.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseDao extends JpaRepository<Response,Integer> {
}

