package com.antifraud_system.antifraud_system.dto;

import com.antifraud_system.antifraud_system.model.Clinica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClinicaDTO {

    private Long id;
    private String nome;
    private String cnpj;

    // Convertendo a entidade Clinica para ClinicaDTO
    public static ClinicaDTO fromEntity(Clinica clinica){
        return new ClinicaDTO(
                clinica.getId(),
                clinica.getNome(),
                clinica.getCnpj()
        );
    }
    // Convertendo o ClinicaDTO para entidade Clínica
    public Clinica toEntity(){
        Clinica clinica = new Clinica();
        clinica.setId(this.id);
        clinica.setNome(this.nome);
        clinica.setCnpj(this.cnpj);
        return clinica;
    };
}
