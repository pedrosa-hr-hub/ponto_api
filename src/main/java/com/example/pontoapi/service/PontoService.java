package com.example.pontoapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pontoapi.dto.PontoResponse;
import com.example.pontoapi.model.Ponto;
import com.example.pontoapi.repository.PontoRepository;

@Service
public class PontoService {

    @Autowired
    private PontoRepository pontoRepository;

    public PontoResponse registrar(PontoResponse dto) {

        Ponto ponto = new Ponto(null, null, dto.getCPF(), dto.getPIS(), dto.getHorario());

        Ponto salvo = pontoRepository.save(ponto);

        return new PontoResponse(salvo.getNSR(), salvo.getCPF(), salvo.getPIS(), salvo.getHorario());
    }

    public List<PontoResponse> listarTodos() {
        return pontoRepository.findAll().stream()
                .map(p -> new PontoResponse(p.getNSR(), p.getCPF(), p.getPIS(), p.getHorario()))
                .collect(Collectors.toList());
    }
}