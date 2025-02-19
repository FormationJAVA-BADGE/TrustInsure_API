package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Contrat;
import com.example.TrustInsure.model.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IExpertiseRepository extends JpaRepository<Expertise, Long>  {

    List<Expertise> findByExpertId(Long expertId);
    List<Expertise> findBySinistreId(Long sinistreId);
}

