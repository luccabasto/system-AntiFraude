package com.antiFraud.system.antiFraud.repository;

import com.antiFraud.system.antiFraud.model.ClienteSuspeito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteSuspeitoRepository extends JpaRepository<ClienteSuspeito, Long> {
}
