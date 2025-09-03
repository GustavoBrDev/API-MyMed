package com.ifsc.ctds.my_med_api.repository;

import com.ifsc.ctds.my_med_api.models.Alarme;
import com.ifsc.ctds.my_med_api.models.Relato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlarmeRepository extends JpaRepository<Alarme, Long> {

    List<Alarme> findByMedicamento_ID(Long id);
}
