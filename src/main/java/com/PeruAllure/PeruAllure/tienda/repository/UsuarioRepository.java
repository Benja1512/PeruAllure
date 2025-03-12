package com.peruallure.peruallure.tienda.repository;

import com.peruallure.peruallure.tienda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método para encontrar un usuario por correo electrónico, devolviendo Optional
    Optional<Usuario> findByCorreoElectronico(String correoElectronico);
}
