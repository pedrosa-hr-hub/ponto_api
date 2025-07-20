package com.example.pontoapi.dto;

import java.time.LocalDateTime;

public record PontoResponse(Long NSR, String CPF, String PIS, LocalDateTime horario) {
}
