package com.peruallure.peruallure.tienda.controller;

import com.peruallure.peruallure.tienda.model.Compra;
import com.peruallure.peruallure.tienda.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    // Obtener todas las compras
    @GetMapping
    public List<Compra> obtenerTodasLasCompras() {
        return compraService.obtenerTodasLasCompras();
    }

    // Obtener compras de un usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<Compra> obtenerComprasPorUsuario(@PathVariable Long usuarioId) {
        return compraService.obtenerComprasPorUsuario(usuarioId);
    }

    // Crear una nueva compra
    @PostMapping
    public Compra crearCompra(@RequestBody Compra compra) {
        return compraService.crearCompra(compra);
    }

    // Actualizar una compra
    @PutMapping("/{id}")
    public ResponseEntity<Compra> actualizarCompra(@PathVariable Long id, @RequestBody Compra compra) {
        Compra compraActualizada = compraService.actualizarCompra(id, compra);
        return compraActualizada != null ? ResponseEntity.ok(compraActualizada) : ResponseEntity.notFound().build();
    }

    // Eliminar una compra
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCompra(@PathVariable Long id) {
        compraService.eliminarCompra(id);
        return ResponseEntity.noContent().build();
    }
}
