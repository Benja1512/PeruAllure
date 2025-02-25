package com.peruallure.peruallure.tienda.repository;

import com.peruallure.peruallure.tienda.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    // Métodos adicionales si es necesario
}
