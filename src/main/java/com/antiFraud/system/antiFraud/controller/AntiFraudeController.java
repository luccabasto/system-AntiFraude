package com.antiFraud.system.antiFraud.controller;

import com.antiFraud.system.antiFraud.DTO.BeneficiarioDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.antiFraud.system.antiFraud.service.AnaliseFraudeService;

@RestController
@RequestMapping("/api/anti-fraude")
public class AntiFraudeController {

    @Autowired
    private  AnaliseFraudeService analiseFraudeService;

    @PostMapping("/analisar")
    public ResponseEntity<Void> analisarFraude(@Valid @RequestBody BeneficiarioDTO beneficiarioDTO){
        analiseFraudeService.analisarFraude(beneficiarioDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
