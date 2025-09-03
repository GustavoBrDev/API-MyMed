package com.ifsc.ctds.my_med_api.repository;

import com.ifsc.ctds.my_med_api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
