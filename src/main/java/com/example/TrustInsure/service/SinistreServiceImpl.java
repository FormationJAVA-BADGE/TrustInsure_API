package com.example.TrustInsure.service;

import com.example.TrustInsure.dto.SinistreDTO;
import com.example.TrustInsure.model.Contrat;
import com.example.TrustInsure.model.Document;
import com.example.TrustInsure.model.Sinistre;
import com.example.TrustInsure.repository.IContratRepository;
import com.example.TrustInsure.repository.IDocumentRepository;
import com.example.TrustInsure.repository.ISinistreRepository;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SinistreServiceImpl implements ISinistreService {

    private final ISinistreRepository sinistreRepository;
    private final IContratRepository contratRepository;
    private final IDocumentRepository documentRepository;

    public SinistreServiceImpl(ISinistreRepository sinistreRepository,
                               IContratRepository contratRepository,
                               IDocumentRepository documentRepository
                               ) {
        this.sinistreRepository = sinistreRepository;
        this.contratRepository = contratRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public SinistreDTO creerSinistre(SinistreDTO sinistreDTO) {
        // Vérification du contrat
        Contrat contrat = contratRepository.findById(sinistreDTO.getContratId()).orElseThrow(
                ()-> new RuntimeException("Contrat introuvable.")
        );

        // Vérification de la date du sinistre
        if (sinistreDTO.getDateSinistre().isAfter(LocalDateTime.now())) {
            throw new RuntimeException("La date du sinistre ne peut pas être dans le futur.");
        }

        // Création de l'entité Sinistre
        Sinistre sinistre = new Sinistre();
        sinistre.setTypeSinistre(sinistreDTO.getTypeSinistre());
        sinistre.setDateSinistre(sinistreDTO.getDateSinistre());
        sinistre.setDescription(sinistreDTO.getDescription());
        sinistre.setStatut("En attente de validation");
        sinistre.setContrat(contrat);

        // Sauvegarde du sinistre en base
        sinistre = sinistreRepository.save(sinistre);

        // Ajout des documents
        List<Document> documents = new ArrayList<>();
        if (sinistreDTO.getDocumentsUrls() != null && !sinistreDTO.getDocumentsUrls().isEmpty()) {
            for (String url : sinistreDTO.getDocumentsUrls()) {
                Document document = new Document("Photo", url, sinistre);
                documents.add(document);
            }
            documentRepository.saveAll(documents);
        }

        // Retourne le DTO
        return convertirEnDTO(sinistre);
    }

    @Override
    public List<SinistreDTO> getSinistresByClientId(Long clientId) {
        return List.of();
    }


    @Override
    public SinistreDTO getSinistreById(Long sinistreId) {
        Sinistre sinistre = sinistreRepository.findById(sinistreId).orElseThrow(
                ()-> new RuntimeException("Sinistre introuvable.")
        );

        return convertirEnDTO(sinistre);
    }

    @Override
    public SinistreDTO modifierSinistre(Long sinistreId, String updatedStatut) {
        Sinistre sinistre = sinistreRepository.findById(sinistreId).orElseThrow(
                ()-> new RuntimeException("Sinistre introuvable.")
        );


        sinistre.setStatut(updatedStatut);
        sinistreRepository.save(sinistre);
        return convertirEnDTO(sinistre);
    }



    private SinistreDTO convertirEnDTO(Sinistre sinistre) {
        return new SinistreDTO(
                sinistre.getId(),
                sinistre.getTypeSinistre(),
                sinistre.getDateSinistre(),
                sinistre.getDescription(),
                sinistre.getStatut(),
                sinistre.getContrat().getId(), // Correction : On retourne le contratId et non clientId
                sinistre.getDocuments() != null ?
                        sinistre.getDocuments().stream().map(Document::getUrl).collect(Collectors.toList()) :
                        new ArrayList<>()
        );
    }
}
