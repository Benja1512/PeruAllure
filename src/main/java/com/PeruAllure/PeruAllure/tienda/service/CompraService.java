package com.peruallure.peruallure.tienda.service;

import com.peruallure.peruallure.tienda.model.Compra;
import com.peruallure.peruallure.tienda.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    // Obtener todas las compras
    public List<Compra> obtenerTodasLasCompras() {
        return compraRepository.findAll();
    }

    // Obtener compras por usuario
    public List<Compra> obtenerComprasPorUsuario(Long usuarioId) {
        return compraRepository.findByUsuarioId(usuarioId);
    }

    // Crear una nueva compra
    public Compra crearCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    // Actualizar una compra existente
    public Compra actualizarCompra(Long id, Compra compraActualizada) {
        if (compraRepository.existsById(id)) {
            compraActualizada.setId(id);
            return compraRepository.save(compraActualizada);
        }
        return null; // Retornar null si no existe
    }

    // Eliminar una compra
    public void eliminarCompra(Long id) {
        compraRepository.deleteById(id);
    }
}
