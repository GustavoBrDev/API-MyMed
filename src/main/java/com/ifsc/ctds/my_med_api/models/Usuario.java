package com.ifsc.ctds.my_med_api.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Usuario {

    private String nome;

    private String email;

    private String password;

    private LocalDate dataNascimento;

    @CreatedDate
    private LocalDateTime createdAt;

    private boolean isInactive;

    private Usuario usuario;
}
