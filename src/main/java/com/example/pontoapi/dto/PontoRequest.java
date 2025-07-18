package com.example.pontoapi.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PontoRequest {
    @NotNull
    private LocalDateTime horario;
}
