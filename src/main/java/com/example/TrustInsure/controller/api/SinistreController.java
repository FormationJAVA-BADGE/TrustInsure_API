package com.example.TrustInsure.controller.api;

import com.example.TrustInsure.dto.SinistreDTO;
import com.example.TrustInsure.model.Sinistre;
import com.example.TrustInsure.service.ISinistreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sinistres")
public class SinistreController {

    private final ISinistreService sinistreService;

    public SinistreController(ISinistreService sinistreService) {
        this.sinistreService = sinistreService;
    }

    @PostMapping("/{clientId}")
    public SinistreDTO creerSinistre(@PathVariable Long clientId, @RequestBody SinistreDTO sinistre) {
        return sinistreService.creerSinistre(sinistre);
    }

    @GetMapping("/{sinistreId}")
    public SinistreDTO getSinistreById(@PathVariable Long sinistreId) {
        return sinistreService.getSinistreById(sinistreId);
    }

    @GetMapping("/client/{clientId}")
    public List<SinistreDTO> getSinistresByClient(@PathVariable Long clientId) {
        return sinistreService.getSinistresByClientId(clientId);
    }

    @PatchMapping("/{sinistreId}/statut")
    public SinistreDTO modifierStatutSinistre(@PathVariable Long sinistreId, @RequestBody String nouveauStatut) {
        return sinistreService.modifierSinistre(sinistreId, nouveauStatut);
    }
}
