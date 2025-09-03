package com.ifsc.ctds.my_med_api.repository;

import com.ifsc.ctds.my_med_api.models.Relato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelatoRepository extends JpaRepository<Relato, Long> {

    List<Relato> findByMedicamento_id(Long id);
}
