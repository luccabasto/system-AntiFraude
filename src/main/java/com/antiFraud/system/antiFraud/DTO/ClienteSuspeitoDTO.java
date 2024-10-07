package com.antiFraud.system.antiFraud.DTO;

import jakarta.validation.constraints.NotEmpty;

public class ClienteSuspeitoDTO {

    @NotEmpty
    private String nome;
    @NotEmpty
    private String motivo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


}
