
package com.ejemplo.apividrios.repository;

import com.ejemplo.apividrios.entity.Vidrio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VidrioRepository extends JpaRepository<Vidrio, Long> {

    // Buscar vidrios por tipo
    List<Vidrio> findByTipoIgnoreCase(String tipo);

}

