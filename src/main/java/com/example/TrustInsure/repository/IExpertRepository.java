package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Expert;

import java.util.List;

public interface IExpertRepository {
    Expert findById(Long id);
    List<Expert> findAll();
}
