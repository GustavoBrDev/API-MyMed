package com.ifsc.ctds.my_med_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String observacoes;
}