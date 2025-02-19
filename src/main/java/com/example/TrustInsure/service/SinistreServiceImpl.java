package com.example.TrustInsure.service;

import com.example.TrustInsure.dto.SinistreDTO;
import com.example.TrustInsure.model.Client;
import com.example.TrustInsure.model.Document;
import com.example.TrustInsure.model.Sinistre;
import com.example.TrustInsure.repository.IClientRepository;
import com.example.TrustInsure.repository.IDocumentRepository;
import com.example.TrustInsure.repository.IClientRepository;
import com.example.TrustInsure.repository.ISinistreRepository;
import com.example.TrustInsure.repository.ISinistreRepository;
import org.hibernate.SessionFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SinistreServiceImpl implements ISinistreService {

    private final ISinistreRepository sinistreRepository;
    private final IClientRepository clientRepository;
    private final IDocumentRepository documentRepository;
    private final SessionFactory sessionFactory;

    public SinistreServiceImpl(ISinistreRepository sinistreRepository,
                               IClientRepository clientRepository,
                               IDocumentRepository documentRepository,
                               SessionFactory sessionFactory) {
        this.sinistreRepository = sinistreRepository;
        this.clientRepository = clientRepository;
        this.documentRepository = documentRepository;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SinistreDTO creerSinistre(SinistreDTO sinistreDTO) {
        // Vérification du client
        Client client = clientRepository.findById(sinistreDTO.getClientId());
        if (client == null) {
            throw new RuntimeException("Client introuvable.");
        }

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
        sinistre.setClient(client);

        // Sauvegarde du sinistre en base
        List<Document> documents = new ArrayList<>();
        if (sinistreDTO.getDocumentsUrls() != null && !sinistreDTO.getDocumentsUrls().isEmpty()) {
            for (String url : sinistreDTO.getDocumentsUrls()) {
                Document document = new Document("Photo", url, sinistre);
                documents.add(document);
            }
            documentRepository.saveAll(documents);
        }


        // Conversion en DTO avant de retourner la réponse
        return convertirEnDTO(sinistre);
    }

    @Override
    public List<SinistreDTO> getSinistresParClientId(Long clientId) {
        List<Sinistre> sinistres = sinistreRepository.findByClientId(clientId);
        return sinistres.stream().map(this::convertirEnDTO).collect(Collectors.toList());
    }

    @Override
    public SinistreDTO getSinistreById(Long sinistreId) {
        Sinistre sinistre = sinistreRepository.findById(sinistreId);
        if (sinistre == null) {
            throw new RuntimeException("Sinistre introuvable.");
        }
        return convertirEnDTO(sinistre);
    }

    @Override
    public SinistreDTO modifierSinistre(Long sinistreId, String updatedSinistre) {
        Sinistre sinistre = sinistreRepository.findById(sinistreId);
        if (sinistre == null) {
            throw new RuntimeException("Sinistre introuvable.");
        }

        sinistre.setStatut(updatedSinistre);
        sinistreRepository.update(sinistre);
        return convertirEnDTO(sinistre);
    }



     private SinistreDTO convertirEnDTO(Sinistre sinistre) {
        return new SinistreDTO(
                sinistre.getId(),
                sinistre.getTypeSinistre(),
                sinistre.getDateSinistre(),
                sinistre.getDescription(),
                sinistre.getStatut(),
                sinistre.getClient().getId()
        );
    }

}
