package com.ifsc.ctds.my_med_api.repository;

import com.ifsc.ctds.my_med_api.models.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}
