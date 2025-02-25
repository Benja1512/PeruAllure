package com.peruallure.peruallure.tienda.controller;

import com.peruallure.peruallure.tienda.model.Administrador;
import com.peruallure.peruallure.tienda.service.AdministradorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

    private static final Logger logger = LoggerFactory.getLogger(AdministradorController.class);

    @Autowired
    private AdministradorService administradorService;

    /**
     * Obtiene todos los administradores.
     */
    @GetMapping
    public ResponseEntity<List<Administrador>> getAllAdministradores() {
        logger.info("Obteniendo todos los administradores");
        List<Administrador> administradores = administradorService.findAll();
        return ResponseEntity.ok(administradores);
    }

    /**
     * Obtiene un administrador por ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Administrador> getAdministradorById(@PathVariable Long id) {
        logger.info("Obteniendo administrador con ID: {}", id);
        return administradorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crea un nuevo administrador.
     */
    @PostMapping
    public ResponseEntity<?> createAdministrador(@Valid @RequestBody Administrador administrador) {
        try {
            logger.info("Creando nuevo administrador: {}", administrador);
            Administrador createdAdministrador = administradorService.save(administrador);
            return ResponseEntity.created(URI.create("/api/administradores/" + createdAdministrador.getId()))
                    .body(createdAdministrador);
        } catch (Exception e) {
            logger.error("Error al crear administrador", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el administrador: " + e.getMessage());
        }
    }

    /**
     * Actualiza un administrador existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdministrador(
            @PathVariable Long id,
            @Valid @RequestBody Administrador administrador) {
        logger.info("Actualizando administrador con ID: {}", id);

        if (!administradorService.findById(id).isPresent()) {
            logger.warn("Administrador con ID: {} no encontrado", id);
            return ResponseEntity.notFound().build();
        }

        try {
            administrador.setId(id);
            Administrador updatedAdministrador = administradorService.save(administrador);
            return ResponseEntity.ok(updatedAdministrador);
        } catch (Exception e) {
            logger.error("Error al actualizar administrador", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el administrador: " + e.getMessage());
        }
    }

    /**
     * Elimina un administrador por ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdministrador(@PathVariable Long id) {
        logger.info("Eliminando administrador con ID: {}", id);

        if (!administradorService.findById(id).isPresent()) {
            logger.warn("Administrador con ID: {} no encontrado", id);
            return ResponseEntity.notFound().build();
        }

        try {
            administradorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error al eliminar administrador", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el administrador: " + e.getMessage());
        }
    }
}
