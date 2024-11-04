package com.antifraud_system.antifraud_system.service;

import com.antifraud_system.antifraud_system.dto.FraudeDTO;
import com.antifraud_system.antifraud_system.model.AnaliseFraude;
import com.antifraud_system.antifraud_system.repository.AnaliseFraudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class FraudeServiceImpl implements FraudeService {

    @Autowired
    private AnaliseFraudeRepository analiseFraudeRepository;

    @Override
    public FraudeDTO analisarBeneficiarioSuspeito(Long beneficiarioId) {
        FraudeDTO fraudeDTO = new FraudeDTO();
        fraudeDTO.setSuspeitaFraude(true);
        fraudeDTO.setDescricao("Beneficiário com comportamento suspeito.");

        AnaliseFraude analise = new AnaliseFraude();
        analise.setBeneficiarioId(beneficiarioId);
        analise.setDescricao(fraudeDTO.getDescricao());
        analise.setDataAnalise(LocalDateTime.now());
        analise.setSuspeitaFraude(fraudeDTO.isSuspeitaFraude());
        analiseFraudeRepository.save(analise);

        return fraudeDTO;
    }

    @Override
    public FraudeDTO analisarClinicaSuspeita(Long clinicaId) {
        FraudeDTO fraudeDTO = new FraudeDTO();
        fraudeDTO.setSuspeitaFraude(true);
        fraudeDTO.setDescricao("Clínica com atividades suspeitas.");

        AnaliseFraude analise = new AnaliseFraude();
        analise.setClinicaId(clinicaId);
        analise.setDescricao(fraudeDTO.getDescricao());
        analise.setDataAnalise(LocalDateTime.now());
        analise.setSuspeitaFraude(fraudeDTO.isSuspeitaFraude());
        analiseFraudeRepository.save(analise);

        return fraudeDTO;
    }
}
