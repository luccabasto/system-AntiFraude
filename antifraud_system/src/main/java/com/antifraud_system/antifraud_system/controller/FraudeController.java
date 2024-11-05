package com.antifraud_system.antifraud_system.controller;

import com.antifraud_system.antifraud_system.dto.AnaliseFraudeDTO;
import com.antifraud_system.antifraud_system.service.FraudeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fraude")
@Tag(name = "FraudeController", description = "Endpoints para detecção de fraudes em beneficiários e clínicas")
public class FraudeController {

    @Autowired
    private FraudeService fraudeService;

    @PostMapping("/analisar/beneficiario/{beneficiarioId}")
    @Operation(summary = "Analisar fraudes para um beneficiário", description = "Analisa se o beneficiário tem comportamentos suspeitos de fraude")
    public ResponseEntity<AnaliseFraudeDTO> analisarFraudeBeneficiario(@PathVariable Long beneficiarioId) {
        AnaliseFraudeDTO resultado = fraudeService.buscarAnaliseFraudePorId(beneficiarioId);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/analisar/clinica/{clinicaId}")
    @Operation(summary = "Analisar fraudes para uma clínica", description = "Analisa se a clínica apresenta atividades suspeitas de fraude")
    public ResponseEntity<AnaliseFraudeDTO> analisarFraudeClinica(@PathVariable Long clinicaId) {
        AnaliseFraudeDTO resultado = fraudeService.buscarAnaliseFraudePorId(clinicaId);
        return ResponseEntity.ok(resultado);
    }
}