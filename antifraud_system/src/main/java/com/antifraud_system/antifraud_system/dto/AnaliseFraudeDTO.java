package com.antifraud_system.antifraud_system.dto;

import com.antifraud_system.antifraud_system.model.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnaliseFraudeDTO {

    private Long id;
    private Long beneficiarioId;
    private Long clinicaId;
    private LocalDateTime dataAnalise;
    private boolean suspeitaFraude;
    private String descricao;

    public static AnaliseFraudeDTO fromEntity(AnaliseFraude analiseFraude) {
        return new AnaliseFraudeDTO(
                analiseFraude.getId(),
                analiseFraude.getBeneficiarioId().getId(),
                analiseFraude.getClinicaId().getId(),
                analiseFraude.getDataAnalise(),
                analiseFraude.isSuspeitaFraude(),
                analiseFraude.getDescricao()
        );
    }

    public AnaliseFraude toEntity(Beneficiario beneficiario, Clinica clinica) {
        AnaliseFraude analiseFraude = new AnaliseFraude();
        analiseFraude.setId(this.id);
        analiseFraude.setBeneficiarioId(beneficiario);
        analiseFraude.setClinicaId(clinica);
        analiseFraude.setDataAnalise(this.dataAnalise != null ? this.dataAnalise : LocalDateTime.now());
        analiseFraude.setSuspeitaFraude(this.suspeitaFraude);
        analiseFraude.setDescricao(this.descricao);
        return analiseFraude;
    }
}
