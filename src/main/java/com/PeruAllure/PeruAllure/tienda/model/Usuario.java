package com.peruallure.peruallure.tienda.model;

import org.mindrot.jbcrypt.BCrypt;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @NotBlank(message = "Los apellidos no pueden estar vacíos")
    @Size(max = 200, message = "Los apellidos no pueden exceder los 200 caracteres")
    @Column(nullable = false, length = 200)
    private String apellidos;

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @Size(max = 100, message = "El nombre de usuario no puede exceder los 100 caracteres")
    @Column(nullable = false, length = 100, unique = true)
    private String nombreUsuario;  // Campo nuevo de nombre de usuario

    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "El correo electrónico debe ser válido")
    @Size(max = 100, message = "El correo electrónico no puede exceder los 100 caracteres")
    @Column(nullable = false, length = 100, unique = true)
    private String correoElectronico;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Column(nullable = false)
    private String contrasenaHash;

    // Campos adicionales
    @Column(nullable = true, length = 4)
    private String ultimos4DigitosTarjeta;

    @Column(nullable = true, length = 5)
    private String fechaExpiracion;

    @Column(nullable = true, length = 100)
    private String titularTarjeta;

    @Column(nullable = true, length = 255)
    private String tokenPago;

    @Column(nullable = true)
    private Integer edad;

    @Column(nullable = true)
    private String genero;

    @Column(nullable = true, length = 100)
    private String ciudad;

    @Column(nullable = true, length = 200)
    private String direccion;

    @Column(nullable = true)
    private LocalDate fechaNacimiento;

    @Column(nullable = true, length = 15)
    private String telefono;

    @Column(nullable = true)
    private LocalDateTime ultimaActualizacion;

    @Column(nullable = true, length = 255)
    private String imagenPerfil;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(String nombre, String apellidos, String nombreUsuario, String correoElectronico, String contrasena, Integer edad, String genero, String ciudad, String direccion, LocalDate fechaNacimiento, String ultimos4DigitosTarjeta, String fechaExpiracion, String titularTarjeta, String tokenPago) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
        this.contrasenaHash = hashPassword(contrasena);
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.ultimos4DigitosTarjeta = ultimos4DigitosTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.titularTarjeta = titularTarjeta;
        this.tokenPago = tokenPago;
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Getters y Setters para todos los campos, incluyendo los adicionales
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public void setContrasena(String contrasena) {
        this.contrasenaHash = hashPassword(contrasena);
    }

    public boolean verificarContrasena(String contrasena) {
        return BCrypt.checkpw(contrasena, contrasenaHash);
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", telefono='" + telefono + '\'' +
                ", ultimos4DigitosTarjeta='" + ultimos4DigitosTarjeta + '\'' +
                ", fechaExpiracion='" + fechaExpiracion + '\'' +
                ", titularTarjeta='" + titularTarjeta + '\'' +
                ", tokenPago='" + tokenPago + '\'' +
                '}';
    }
}
