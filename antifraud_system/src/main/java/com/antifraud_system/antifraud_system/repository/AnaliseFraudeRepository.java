package com.antifraud_system.antifraud_system.repository;

import com.antifraud_system.antifraud_system.model.AnaliseFraude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AnaliseFraudeRepository extends JpaRepository<AnaliseFraude, Long> {

    // Busca todas as análises de fraude para um beneficiário específico
    List<AnaliseFraude> findByBeneficiarioId(Long beneficiarioId);

    // Busca todas as análises de fraude para uma clínica específica
    List<AnaliseFraude> findByClinicaId(Long clinicaId);

    // Busca análises de fraude recentes (últimos 30 dias) para beneficiários
    @Query("SELECT a FROM AnaliseFraude a WHERE a.beneficiarioId = :beneficiarioId AND a.dataAnalise >= :dataInicio")
    List<AnaliseFraude> findRecentesParaBeneficiario(@Param("beneficiarioId") Long beneficiarioId, @Param("dataInicio") LocalDateTime dataInicio);

    // Busca análises de fraude recentes (últimos 30 dias) para clínicas
    @Query("SELECT a FROM AnaliseFraude a WHERE a.clinicaId = :clinicaId AND a.dataAnalise >= :dataInicio")
    List<AnaliseFraude> findRecentesParaClinica(@Param("clinicaId") Long clinicaId, @Param("dataInicio") LocalDateTime dataInicio);

    // Busca análises com suspeita de fraude em um período específico
    @Query("SELECT a FROM AnaliseFraude a WHERE a.suspeitaFraude = true AND a.dataAnalise BETWEEN :dataInicio AND :dataFim")
    List<AnaliseFraude> findSuspeitasEmPeriodo(@Param("dataInicio") LocalDateTime dataInicio, @Param("dataFim") LocalDateTime dataFim);

    // Busca todas as análises de fraude marcadas como suspeitas
    List<AnaliseFraude> findBySuspeitaFraudeTrue();
}