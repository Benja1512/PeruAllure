package com.peruallure.peruallure.tienda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.peruallure.peruallure.tienda.enums.Rol; // ✅ Importa la enum Rol

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "administrador")
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 3, max = 100, message = "El apellido debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String apellido;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El formato del email es incorrecto")
    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING) // 🔥 Guarda el Enum como texto en la BD
    @Column(nullable = false, length = 50)
    private Rol rol;  // 🔥 Ahora es un Enum

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @ToString.Exclude
    @Column(nullable = false)
    private String contrasena;

    public Administrador(Long id, String nombre, String apellido, String email, Rol rol, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rol = rol;
        this.contrasena = contrasena;
    }
}

