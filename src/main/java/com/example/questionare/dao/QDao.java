package com.example.questionare.dao;

import com.example.questionare.models.Q;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QDao extends JpaRepository<Q,Integer> {
}
