package com.antifraud_system.antifraud_system.service;

import com.antifraud_system.antifraud_system.dto.AnaliseFraudeDTO;

import java.util.List;

public interface FraudeService {

    AnaliseFraudeDTO criarAnaliseFraude(AnaliseFraudeDTO analiseFraudeDTO);
    List<AnaliseFraudeDTO> listarAnaliseFraude();
    AnaliseFraudeDTO buscarAnaliseFraudePorId(Long id);
    void excluirAnaliseFraude(Long id);
}
