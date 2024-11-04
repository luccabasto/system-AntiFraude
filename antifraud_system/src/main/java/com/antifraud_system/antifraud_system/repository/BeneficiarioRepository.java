package com.antifraud_system.antifraud_system.repository;

import com.antifraud_system.antifraud_system.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

    // Encontra beneficiários por CPF (útil para verificar se já existe algum cadastro)
    Beneficiario findByCpf(String cpf);

    // Encontra beneficiários que possuem múltiplas análises de fraude
    @Query("SELECT b FROM Beneficiario b WHERE b.id IN (SELECT a.beneficiarioId FROM AnaliseFraude a WHERE a.suspeitaFraude = true)")
    List<Beneficiario> findSuspeitosComAnalisasDeFraude();

    // Encontra beneficiários específicos com base em um nome semelhante
    List<Beneficiario> findByNomeContainingIgnoreCase(String nome);
}