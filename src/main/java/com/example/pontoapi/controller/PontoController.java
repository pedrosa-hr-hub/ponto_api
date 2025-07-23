package com.example.pontoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pontoapi.dto.PontoResponse;
import com.example.pontoapi.service.PontoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/ponto")
public class PontoController {

    @Autowired
    private PontoService pontoService;

    @PostMapping
    public ResponseEntity<PontoResponse> registrarPonto(@RequestBody PontoResponse dto) {

        if (dto.CPF() == null || dto.CPF().isBlank()) {

            return ResponseEntity.badRequest().body(null);

        } else {
            PontoResponse salvo = pontoService.registrar(dto);

            return ResponseEntity.ok(salvo);

        }
    }

    @GetMapping
    public ResponseEntity<List<PontoResponse>> listarTdos() {
        List<PontoResponse> ponto = pontoService.listarTodos();
        return ResponseEntity.ok(ponto);
    }

}
