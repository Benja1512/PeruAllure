package com.peruallure.peruallure.tienda.controller;

import com.peruallure.peruallure.tienda.model.Usuario;
import com.peruallure.peruallure.tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioService.obtenerTodosUsuarios();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo usuario
    @PostMapping("/registrar")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        // Imprimir los datos recibidos para asegurarse de que se están enviando correctamente
        System.out.println("Recibido usuario: " + usuario);

        return usuarioService.crearUsuario(usuario);
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(id, usuario);
        return usuarioActualizado != null ? ResponseEntity.ok(usuarioActualizado) : ResponseEntity.notFound().build();
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
