package com.antifraud_system.antifraud_system.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String cnpj;

    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnaliseFraude> analisesFraude;

    // Método auxiliar para criar uma nova clínica
    public static Clinica criarNova(String nome, String cnpj) {
        Clinica clinica = new Clinica();
        clinica.setNome(nome);
        clinica.setCnpj(cnpj);
        return clinica;
    }
}