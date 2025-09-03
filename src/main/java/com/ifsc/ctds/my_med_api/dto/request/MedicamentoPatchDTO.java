package com.ifsc.ctds.my_med_api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoPatchDTO {

    private String nome;
    private String descricao;
    private String observacoes;
}
