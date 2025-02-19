package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExpertRepository extends JpaRepository<Expert,Long> {

}
