package com.antifraud_system.antifraud_system.service;

import com.antifraud_system.antifraud_system.dto.FraudeDTO;

public interface FraudeService {
    FraudeDTO analisarBeneficiarioSuspeito(Long beneficiarioId);
    FraudeDTO analisarClinicaSuspeita(Long clinicaId);
}
