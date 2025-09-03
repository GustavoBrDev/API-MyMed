package com.ifsc.ctds.my_med_api.controller;

import com.ifsc.ctds.my_med_api.dto.request.MedicamentoPatchDTO;
import com.ifsc.ctds.my_med_api.dto.request.MedicamentoRequestDTO;
import com.ifsc.ctds.my_med_api.dto.response.MedicamentoResponseDTO;
import com.ifsc.ctds.my_med_api.service.MedicamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    private final MedicamentoService service;

    @PostMapping
    public ResponseEntity<MedicamentoResponseDTO> create(@Valid @RequestBody MedicamentoRequestDTO dto) {
        MedicamentoResponseDTO created = service.create(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody MedicamentoRequestDTO dto) {
        MedicamentoResponseDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MedicamentoResponseDTO> patch(
            @PathVariable Long id,
            @RequestBody MedicamentoPatchDTO dto) {
        MedicamentoResponseDTO patched = service.patch(id, dto);
        return ResponseEntity.ok(patched);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoResponseDTO> getById(@PathVariable Long id) {
        MedicamentoResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoResponseDTO>> getAll() {
        List<MedicamentoResponseDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}