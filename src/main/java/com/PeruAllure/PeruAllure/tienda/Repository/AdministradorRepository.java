package com.PeruAllure.PeruAllure.tienda.Repository;

import com.PeruAllure.PeruAllure.tienda.Model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    // Métodos adicionales si es necesario
}
