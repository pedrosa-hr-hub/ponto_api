package com.example.pontoapi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PontoResponse {
    private Long NSR;
    private String CPF;
    private String PIS;
    private LocalDateTime horario;
}
