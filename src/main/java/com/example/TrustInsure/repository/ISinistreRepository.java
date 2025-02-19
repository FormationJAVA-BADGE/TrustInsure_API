package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Contrat;
import com.example.TrustInsure.model.Sinistre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISinistreRepository extends JpaRepository<Sinistre,Long>  {


    List<Sinistre> findByContratId(Long contratId);
}
