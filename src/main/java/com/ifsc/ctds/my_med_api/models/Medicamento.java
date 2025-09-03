package com.ifsc.ctds.my_med_api.models;

import com.ifsc.ctds.my_med_api.dto.response.MedicamentoResponseDTO;
import com.ifsc.ctds.my_med_api.dto.response.ResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Medicamento implements ConvertibleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private String dosagem;

    private String observacoes;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne
    private Usuario usuario;

    @Override
    public MedicamentoResponseDTO convert() {
        return MedicamentoResponseDTO.builder()
                .id(id)
                .nome(nome)
                .dosagem(dosagem)
                .descricao(descricao)
                .observacoes(observacoes)
                .build();
    }
}
