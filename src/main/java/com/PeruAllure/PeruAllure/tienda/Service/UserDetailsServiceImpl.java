package com.PeruAllure.PeruAllure.tienda.Service;

import com.PeruAllure.PeruAllure.tienda.Model.Usuario;
import com.PeruAllure.PeruAllure.tienda.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar el usuario por correo electrónico
        Usuario usuario = usuarioRepository.findByCorreoElectronico(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el correo electrónico: " + username));

        // Devuelve una instancia de User (de Spring Security) con el nombre de usuario y la contraseña hash
        return new User(usuario.getCorreoElectronico(), usuario.getContrasenaHash(), Collections.emptyList());
    }
}
