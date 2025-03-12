package com.peruallure.peruallure.tienda.repository;

import com.peruallure.peruallure.tienda.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    // Puedes agregar métodos personalizados si es necesario
    // Ejemplo: encontrar compras por usuario
    List<Compra> findByUsuarioId(Long usuarioId);
}
