package com.antiFraud.system.antiFraud.repository;

import com.antiFraud.system.antiFraud.model.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Long> {
}