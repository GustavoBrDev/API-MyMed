package com.ifsc.ctds.my_med_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicamentoResponseDTO implements ResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String observacoes;
    private String dosagem;
}