package com.ifsc.ctds.my_med_api.dto.request;

import com.ifsc.ctds.my_med_api.models.BaseModel;
import com.ifsc.ctds.my_med_api.models.Medicamento;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoRequestDTO implements RequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String descricao;

    private String observacoes;

    private String dosagem;

    private Long usuarioId;

    @Override
    public Medicamento convert() {
        return Medicamento.builder()
                .nome(nome)
                .descricao(descricao)
                .observacoes(observacoes)
                .dosagem(dosagem)
                .build();
    }
}
