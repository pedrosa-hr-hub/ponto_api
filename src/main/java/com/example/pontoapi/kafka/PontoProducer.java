package com.example.pontoapi.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.pontoapi.dto.kafka.PontoEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PontoProducer {

    private static final String TOPIC = "ponto-marcado";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void enviarEvento(PontoEvent dto) {
        try {

            String mensagemJson = objectMapper.writeValueAsString(dto);

            kafkaTemplate.send(TOPIC, mensagemJson);

        } catch (Exception e) {

            throw new RuntimeException("Erro no Kafka, transformar evento para JSON", e);

        }
    }
}
