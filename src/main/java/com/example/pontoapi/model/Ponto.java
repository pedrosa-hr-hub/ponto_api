package com.example.pontoapi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @SequenceGenerator(name = "nsr_seq_generator", sequenceName = "nsr_sequence", allocationSize = 1)
    @Getter
    private Long NSR;

    @Setter
    @Getter
    private String CPF;

    @Setter
    @Getter
    private String PIS;

    @Setter
    @Getter
    private LocalDateTime horario;

}
