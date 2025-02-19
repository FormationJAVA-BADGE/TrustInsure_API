package com.example.TrustInsure.repository;


import com.example.TrustInsure.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContratRepository extends JpaRepository<Contrat, Long>  {

    List<Contrat> findByClientId(Long clientId);
}

