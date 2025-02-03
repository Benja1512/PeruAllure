package com.PeruAllure.PeruAllure.tienda.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor // Constructor sin argumentos requerido por JPA
@Table(name = "administrador") // Nombre de la tabla en la base de datos
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L; // Identificador de versión para Serializable

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Autogenera el ID
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
    @Column(nullable = false, unique = true)  // 'email' debe ser único en la BD
    private String email;

    @NotBlank(message = "El rol no puede estar vacío")
    @Size(min = 3, max = 50, message = "El rol debe tener entre 3 y 50 caracteres")
    @Column(nullable = false, length = 50)
    private String rol;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @ToString.Exclude  // Excluye la contraseña del método toString generado por Lombok
    @Column(nullable = false)
    private String contrasena;

    // Constructor con todos los argumentos (opcional)
    public Administrador(Long id, String nombre, String apellido, String email, String rol, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rol = rol;
        this.contrasena = contrasena;
    }

    // Si Lombok no genera el setter, agrega uno manualmente
    public void setId(Long id) {
        this.id = id;
    }
}
