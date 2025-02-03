package com.PeruAllure.PeruAllure.tienda.Controller;

import com.PeruAllure.PeruAllure.tienda.Model.Administrador;
import com.PeruAllure.PeruAllure.tienda.Service.AdministradorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

    private static final Logger logger = LoggerFactory.getLogger(AdministradorController.class);

    @Autowired
    private AdministradorService administradorService;

    @GetMapping
    public List<Administrador> getAllAdministradores() {
        logger.info("Obteniendo todos los administradores");
        return administradorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> getAdministradorById(@PathVariable Long id) {
        logger.info("Obteniendo administrador con ID: {}", id);
        Optional<Administrador> administrador = administradorService.findById(id);
        return administrador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Administrador> createAdministrador(@RequestBody Administrador administrador) {
        logger.info("Creando nuevo administrador: {}", administrador);
        Administrador createdAdministrador = administradorService.save(administrador);
        logger.info("Administrador creado con ID: {}", createdAdministrador.getId());
        return ResponseEntity.created(URI.create("/api/administradores/" + createdAdministrador.getId())).body(createdAdministrador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> updateAdministrador(
            @PathVariable Long id,
            @RequestBody Administrador administrador) {
        logger.info("Actualizando administrador con ID: {}", id);
        if (!administradorService.findById(id).isPresent()) {
            logger.warn("Administrador con ID: {} no encontrado", id);
            return ResponseEntity.notFound().build();
        }
        administrador.setId(id);
        return ResponseEntity.ok(administradorService.save(administrador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrador(@PathVariable Long id) {
        logger.info("Eliminando administrador con ID: {}", id);
        if (!administradorService.findById(id).isPresent()) {
            logger.warn("Administrador con ID: {} no encontrado", id);
            return ResponseEntity.notFound().build();
        }
        administradorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
