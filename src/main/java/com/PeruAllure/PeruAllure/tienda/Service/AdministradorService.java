package com.PeruAllure.PeruAllure.tienda.Service;

import com.PeruAllure.PeruAllure.tienda.Model.Administrador;
import com.PeruAllure.PeruAllure.tienda.Repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Administrador> findAll() {
        return administradorRepository.findAll();
    }

    public Optional<Administrador> findById(Long id) {
        return administradorRepository.findById(id);
    }

    public Administrador save(Administrador administrador) {
        if (administrador.getContrasena() != null) {
            administrador.setContrasena(passwordEncoder.encode(administrador.getContrasena()));
        }
        return administradorRepository.save(administrador);
    }

    public void deleteById(Long id) {
        administradorRepository.deleteById(id);
    }
}
