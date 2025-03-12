package com.peruallure.peruallure.tienda.service;

import com.peruallure.peruallure.tienda.model.Usuario;
import com.peruallure.peruallure.tienda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar usuario por correo electrónico (retorna Optional<Usuario>)
        Usuario usuario = usuarioRepository.findByCorreoElectronico(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el correo: " + username));

        // Retornar un objeto User que Spring Security usará para la autenticación
        return new User(usuario.getCorreoElectronico(), usuario.getContrasenaHash(), Collections.emptyList());
    }
}
