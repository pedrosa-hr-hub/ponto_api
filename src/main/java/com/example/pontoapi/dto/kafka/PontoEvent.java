package com.example.pontoapi.dto.kafka;

import java.time.LocalDateTime;

public record PontoEvent(String cpf, String pis, LocalDateTime horario) {
}