package com.ifsc.ctds.my_med_api.repository;

import com.ifsc.ctds.my_med_api.models.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    List<Medicamento> findByUsuario_ID ( Long id );
}
