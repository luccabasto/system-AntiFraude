package com.antiFraud.system.antiFraud.service;

import com.antiFraud.system.antiFraud.DTO.BeneficiarioDTO;
import com.antiFraud.system.antiFraud.model.Beneficiario;
import com.antiFraud.system.antiFraud.model.ClienteSuspeito;
import com.antiFraud.system.antiFraud.model.Clinica;
import com.antiFraud.system.antiFraud.repository.BeneficiarioRepository;
import com.antiFraud.system.antiFraud.repository.ClienteSuspeitoRepository;
import com.antiFraud.system.antiFraud.repository.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@Service
public class AnaliseFraudeService {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private ClienteSuspeitoRepository clienteSuspeitoRepository;

    private final List<String> clinicasSuspeitas = Arrays.asList("Clínica A", "Clinica B");


    @Transactional
    public void analisarFraude(BeneficiarioDTO beneficiarioDTO){
        try {
            Beneficiario beneficiario = new Beneficiario();
            beneficiario.setNome(beneficiarioDTO.getNome());
            Clinica clinica = clinicaRepository.findById(beneficiarioDTO.getClinicaId())
                    .orElseThrow(() -> new RuntimeException("Clinica não encontrada"));
            beneficiario.setClinica(clinica);
            beneficiarioRepository.save(beneficiario);

            if (beneficiarioDTO.getIdade() < 18){
                ClienteSuspeito clienteSuspeito = new ClienteSuspeito();
                clienteSuspeito.setNome(beneficiarioDTO.getNome());
                clienteSuspeito.setMotivo("Idade menor que 18");
                clienteSuspeitoRepository.save(clienteSuspeito);
            }

            if (clinicasSuspeitas.contains(clinica.getNome())) {
                ClienteSuspeito clienteSuspeito = new ClienteSuspeito();
                clienteSuspeito.setNome(beneficiarioDTO.getNome());
                clienteSuspeito.setMotivo("Clinica suspeita");
                clienteSuspeitoRepository.save(clienteSuspeito);
            }
        } catch (Exception e) {
            // Log da exceção
            System.err.println("Erro ao analisar fraude: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

}
