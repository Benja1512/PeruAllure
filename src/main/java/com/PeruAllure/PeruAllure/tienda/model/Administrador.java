package com.peruallure.peruallure.tienda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Builder;
import java.io.Serializable;

@Entity
@Table(name = "administradores")
@Data // Lombok para generar Getters, Setters, toString, equals y hashCode
@Builder // Permite crear objetos con patrón Builder
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String apellido;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "Formato de email inválido")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "El rol no puede estar vacío")
    @Size(min = 3, max = 50)
    @Column(nullable = false, length = 50)
    private String rol;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 6)
    @Column(nullable = false)
    private String contrasena;

    // **Constructor vacío (requerido por JPA)**
    public Administrador() {
    }

    // **Constructor con todos los atributos**
    public Administrador(Long id, String nombre, String apellido, String email, String rol, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rol = rol;
        this.contrasena = contrasena;
    }

    // **Constructor sin ID (para crear nuevos administradores)**
    public Administrador(String nombre, String apellido, String email, String rol, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rol = rol;
        this.contrasena = contrasena;
    }
}
