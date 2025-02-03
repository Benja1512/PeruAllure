package com.PeruAllure.PeruAllure.tienda.Model;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "El correo electrónico debe ser válido")
    @Size(max = 100, message = "El correo electrónico no puede exceder los 100 caracteres")
    @Column(nullable = false, length = 100, unique = true)
    private String correoElectronico;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Column(nullable = false)
    private String contrasenaHash;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(String nombre, String correoElectronico, String contrasena) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasenaHash = hashPassword(contrasena);
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    // Método para obtener la contraseña encriptada (contrasenaHash)
    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public void setContrasena(String contrasena) {
        this.contrasenaHash = hashPassword(contrasena);
    }

    // Verificación de contraseña con BCrypt
    public boolean verificarContrasena(String contrasena) {
        return BCrypt.checkpw(contrasena, contrasenaHash);
    }

    // Método privado para encriptar la contraseña con BCrypt
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }
}
