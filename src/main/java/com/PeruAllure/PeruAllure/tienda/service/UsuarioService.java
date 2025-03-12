package com.peruallure.peruallure.tienda.service;

import com.peruallure.peruallure.tienda.model.Usuario;
import com.peruallure.peruallure.tienda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Crear un nuevo usuario
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar un usuario existente
    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        if (usuarioRepository.existsById(id)) {
            usuarioActualizado.setId(id);
            return usuarioRepository.save(usuarioActualizado);
        }
        return null; // Retornar null si no existe
    }

    // Eliminar un usuario por ID
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Buscar usuario por correo electrónico
    public Optional<Usuario> buscarPorCorreoElectronico(String correoElectronico) {
        return usuarioRepository.findByCorreoElectronico(correoElectronico);
    }
}
