package com.example.pontoapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pontoapi.dto.PontoResponse;
import com.example.pontoapi.dto.kafka.PontoEvent;
import com.example.pontoapi.kafka.PontoProducer;
import com.example.pontoapi.model.Ponto;
import com.example.pontoapi.repository.PontoRepository;

@Service
public class PontoService {

    @Autowired
    private PontoRepository pontoRepository;

    @Autowired
    private PontoProducer pontoProducer;

    public PontoResponse registrar(PontoResponse dto) {

        // pega os dados que foram filtrados pelo DTO e colocam ele no model
        Ponto ponto = new Ponto(null, null, dto.CPF(), dto.PIS(), dto.horario());

        // salva os dados no banco de dados
        Ponto salvo = pontoRepository.save(ponto);

        // pega os dados que foram salvos no banco e coloca no objeto kafka
        PontoEvent evento = new PontoEvent(salvo.getCPF(), salvo.getPIS(), salvo.getHorario());

        // envia os dados para o kafka
        pontoProducer.enviarEvento(evento);

        // retorna os dados salvos como confirmação que foram salvos
        return new PontoResponse(salvo.getNSR(), salvo.getCPF(), salvo.getPIS(), salvo.getHorario());
    }

    public List<PontoResponse> listarTodos() {
        return pontoRepository.findAll().stream()
                .map(p -> new PontoResponse(p.getNSR(), p.getCPF(), p.getPIS(), p.getHorario()))
                .collect(Collectors.toList());
    }
}