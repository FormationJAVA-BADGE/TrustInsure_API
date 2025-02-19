package com.example.TrustInsure.service;

import com.example.TrustInsure.dto.ExpertiseDTO;

public interface IExpertiseService {
    ExpertiseDTO assignerExpert(Long sinistreId, Long expertId);
    ExpertiseDTO getExpertiseById(Long expertiseId);
}

