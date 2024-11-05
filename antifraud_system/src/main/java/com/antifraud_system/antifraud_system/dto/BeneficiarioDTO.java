package com.antifraud_system.antifraud_system.dto;

import com.antifraud_system.antifraud_system.model.Beneficiario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiarioDTO {

    private Long id;
    private String nome;
    private String cpf;

    public static BeneficiarioDTO fromEntity(Beneficiario beneficiario) {
        return new BeneficiarioDTO(
                beneficiario.getId(),
                beneficiario.getNome(),
                beneficiario.getCpf()
        );
    }

    public Beneficiario toEntity() {
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setId(this.id);
        beneficiario.setNome(this.nome);
        beneficiario.setCpf(this.cpf);
        return beneficiario;
    }
}
