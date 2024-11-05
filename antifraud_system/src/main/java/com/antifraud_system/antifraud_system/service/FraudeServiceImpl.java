package com.antifraud_system.antifraud_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antifraud_system.antifraud_system.dto.AnaliseFraudeDTO;
import com.antifraud_system.antifraud_system.model.*;
import com.antifraud_system.antifraud_system.repository.*;
import com.antifraud_system.antifraud_system.service.FraudeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FraudeServiceImpl implements FraudeService{

    @Autowired
    private AnaliseFraudeRepository analiseFraudeRepository;
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;
    @Autowired
    private ClinicaRepository clinicaRepository;

    @Override
    public AnaliseFraudeDTO criarAnaliseFraude(AnaliseFraudeDTO analiseFraudeDTO){

        Beneficiario beneficiario = beneficiarioRepository.findById(analiseFraudeDTO.getBeneficiarioId())
                .orElseThrow(() -> new RuntimeException("Beneficiário não encontrado"));
        Clinica clinica = clinicaRepository.findById(analiseFraudeDTO.getClinicaId())
                .orElseThrow(() -> new RuntimeException("Clínica não encontrada"));

        AnaliseFraude analiseFraude = analiseFraudeDTO.toEntity(beneficiario, clinica);
        analiseFraude = analiseFraudeRepository.save(analiseFraude);

        return AnaliseFraudeDTO.fromEntity(analiseFraude);
    }

    @Override
    public List<AnaliseFraudeDTO> listarAnaliseFraude(){
        return analiseFraudeRepository.findAll()
                .stream()
                .map(AnaliseFraudeDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AnaliseFraudeDTO buscarAnaliseFraudePorId(Long id){
        AnaliseFraude analiseFraude = analiseFraudeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Análise de fraude não encontrada."));
        return AnaliseFraudeDTO.fromEntity(analiseFraude);
    }

    @Override
    public void excluirAnaliseFraude(Long id){
        analiseFraudeRepository.deleteById(id);
    }
}