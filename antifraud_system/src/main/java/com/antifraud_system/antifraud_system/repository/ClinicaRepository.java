package com.antifraud_system.antifraud_system.repository;

import com.antifraud_system.antifraud_system.model.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClinicaRepository extends JpaRepository<Clinica, Long> {

    // Encontra clínicas por CNPJ, útil para validação de cadastro
    Clinica findByCnpj(String cnpj);

    // Encontra clínicas com múltiplas análises de suspeita de fraude
    @Query("SELECT c FROM Clinica c WHERE c.id IN (SELECT a.clinicaId FROM AnaliseFraude a WHERE a.suspeitaFraude = true)")
    List<Clinica> findClinicasSuspeitas();

    // Encontra clínicas com nomes semelhantes, ignorando maiúsculas/minúsculas
    List<Clinica> findByNomeContainingIgnoreCase(String nome);
}