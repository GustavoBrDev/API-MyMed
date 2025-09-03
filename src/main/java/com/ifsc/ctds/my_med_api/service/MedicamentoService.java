package com.ifsc.ctds.my_med_api.service;

import com.ifsc.ctds.my_med_api.dto.request.MedicamentoPatchDTO;
import com.ifsc.ctds.my_med_api.dto.request.MedicamentoRequestDTO;
import com.ifsc.ctds.my_med_api.dto.response.MedicamentoResponseDTO;
import com.ifsc.ctds.my_med_api.models.Medicamento;
import com.ifsc.ctds.my_med_api.repository.MedicamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MedicamentoService {

    private MedicamentoRepository repository;

    public MedicamentoResponseDTO create(MedicamentoRequestDTO dto) {
        Medicamento entity = toEntity(dto);
        Medicamento saved = repository.save(entity);
        return toResponse(saved);
    }

    public MedicamentoResponseDTO update(Long id, MedicamentoRequestDTO dto) {
        Medicamento existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Medicamento não encontrado com id: " + id));

        // Substitui todos os campos exceto id
        existing.setNome(dto.getNome());
        existing.setDescricao(dto.getDescricao());
        existing.setObservacoes(dto.getObservacoes());

        Medicamento saved = repository.save(existing);
        return toResponse(saved);
    }

    public MedicamentoResponseDTO patch(Long id, MedicamentoPatchDTO dto) {
        Medicamento existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Medicamento não encontrado com id: " + id));

        // Atualiza apenas campos não-nulos
        if (dto.getNome() != null) {
            existing.setNome(dto.getNome());
        }
        if (dto.getDescricao() != null) {
            existing.setDescricao(dto.getDescricao());
        }
        if (dto.getObservacoes() != null) {
            existing.setObservacoes(dto.getObservacoes());
        }

        Medicamento saved = repository.save(existing);
        return toResponse(saved);
    }

    @Transactional(readOnly = true)
    public MedicamentoResponseDTO findById(Long id) {
        Medicamento entity = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Medicamento não encontrado com id: " + id));
        return toResponse(entity);
    }

    @Transactional(readOnly = true)
    public List<MedicamentoResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Medicamento não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }

    private Medicamento toEntity(MedicamentoRequestDTO dto) {
        Medicamento m = new Medicamento();
        m.setNome(dto.getNome());
        m.setDescricao(dto.getDescricao());
        m.setObservacoes(dto.getObservacoes());
        return m;
    }

    private MedicamentoResponseDTO toResponse(Medicamento m) {
        MedicamentoResponseDTO r = new MedicamentoResponseDTO();
        r.setId(m.getId());
        r.setNome(m.getNome());
        r.setDescricao(m.getDescricao());
        r.setObservacoes(m.getObservacoes());
        return r;
    }
}
