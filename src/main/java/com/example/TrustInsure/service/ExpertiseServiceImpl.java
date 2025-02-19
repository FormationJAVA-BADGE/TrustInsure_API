package com.example.TrustInsure.service;

import com.example.TrustInsure.dto.ExpertiseDTO;
import com.example.TrustInsure.model.Expert;
import com.example.TrustInsure.model.Expertise;
import com.example.TrustInsure.model.Sinistre;
import com.example.TrustInsure.repository.IExpertRepository;
import com.example.TrustInsure.repository.IExpertiseRepository;
import com.example.TrustInsure.repository.ISinistreRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExpertiseServiceImpl implements IExpertiseService {
    private final IExpertiseRepository expertiseRepository;
    private final ISinistreRepository sinistreRepository;
    private final IExpertRepository expertRepository;

    public ExpertiseServiceImpl(IExpertiseRepository expertiseRepository, ISinistreRepository sinistreRepository, IExpertRepository expertRepository) {
        this.expertiseRepository = expertiseRepository;
        this.sinistreRepository = sinistreRepository;
        this.expertRepository = expertRepository;
    }

    @Override
    public ExpertiseDTO assignerExpert(Long sinistreId, Long expertId) {
        Sinistre sinistre = sinistreRepository.findById(sinistreId).orElseThrow(
                ()-> new RuntimeException("Sinistre introuvable.")
        );


        Expert expert = expertRepository.findById(expertId).orElseThrow(
                ()-> new RuntimeException("Expert introuvable.")
        );


        // Définition des délais selon le type de sinistre
        Map<String, Integer> delaisExpertise = new HashMap<>();
        delaisExpertise.put("Accident", 7);
        delaisExpertise.put("Incendie", 14);
        delaisExpertise.put("Vol", 10);

        int joursDelai = delaisExpertise.getOrDefault(sinistre.getTypeSinistre(), 7);
        LocalDateTime dateLimiteExpertise = LocalDateTime.now().plusDays(joursDelai);

        // Création de l'expertise
        Expertise expertise = new Expertise(dateLimiteExpertise, "En attente", expert, sinistre);
        expertise = expertiseRepository.save(expertise);

        return convertirEnDTO(expertise);
    }

    @Override
    public ExpertiseDTO getExpertiseById(Long expertiseId) {
        Expertise expertise = expertiseRepository.findById(expertiseId).orElseThrow(
                ()-> new RuntimeException("Expertise introuvable.")
        );
        return convertirEnDTO(expertise);
    }

    private ExpertiseDTO convertirEnDTO(Expertise expertise) {
        return new ExpertiseDTO(
                expertise.getId(),
                expertise.getSinistre().getId(),
                expertise.getExpert().getId(),
                expertise.getDateLimiteExpertise(),
                expertise.getStatut()
        );
    }
}
