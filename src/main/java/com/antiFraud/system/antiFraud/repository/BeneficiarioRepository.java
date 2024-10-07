package com.antiFraud.system.antiFraud.repository;

import com.antiFraud.system.antiFraud.model.Beneficiario;
import com.antiFraud.system.antiFraud.model.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BeneficiarioRepository  extends JpaRepository<Beneficiario, Long> {

}
