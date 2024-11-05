package com.antifraud_system.antifraud_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AnaliseFraude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beneficiario_id", nullable = false)
    private Beneficiario beneficiarioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinica_id", nullable = false)
    private Clinica clinicaId;

    private LocalDateTime dataAnalise;
    private boolean suspeitaFraude;
    private String descricao;

    // Método auxiliar para criar uma nova análise de fraude
    public static AnaliseFraude criarNova(Beneficiario beneficiario, Clinica clinica, boolean suspeitaFraude, String descricao) {
        AnaliseFraude analiseFraude = new AnaliseFraude();
        analiseFraude.setBeneficiarioId(beneficiario);
        analiseFraude.setClinicaId(clinica);
        analiseFraude.setDataAnalise(LocalDateTime.now());
        analiseFraude.setSuspeitaFraude(suspeitaFraude);
        analiseFraude.setDescricao(descricao);
        return analiseFraude;
    }
}