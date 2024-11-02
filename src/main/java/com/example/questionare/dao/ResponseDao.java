package com.example.questionare.dao;

import com.example.questionare.models.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface ResponseDao extends JpaRepository<Response,Integer> {

    @Query("select r.response, count(r) as count from Response r where r.question_id = :questionId group by r.response")
    List<Object[]> findResponseStatisticsByQuestionId
            (@Param("questionId") int questionId);

}

