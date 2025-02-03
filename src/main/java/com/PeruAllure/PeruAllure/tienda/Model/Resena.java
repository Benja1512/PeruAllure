package com.PeruAllure.PeruAllure.tienda.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "resena")
public class Resena implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del producto no puede ser nulo")
    @Column(nullable = false)
    private Long productoId;

    @NotNull(message = "El ID del usuario no puede ser nulo")
    @Column(nullable = false)
    private Long usuarioId;

    @NotNull(message = "La calificación no puede ser nula")
    @Min(value = 1, message = "La calificación debe ser al menos 1")
    @Column(nullable = false)
    private int calificacion;

    @Size(max = 500, message = "El comentario no puede exceder los 500 caracteres")
    @Column(length = 500)
    private String comentario;

    @NotNull(message = "La fecha no puede ser nula")
    @Column(nullable = false)
    private LocalDateTime fecha;

    // Constructor vacío
    public Resena() {}

    // Constructor con parámetros
    public Resena(Long id, Long productoId, Long usuarioId, int calificacion, String comentario, LocalDateTime fecha) {
        this.id = id;
        this.productoId = productoId;
        this.usuarioId = usuarioId;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Resena{" +
                "id=" + id +
                ", productoId=" + productoId +
                ", usuarioId=" + usuarioId +
                ", calificacion=" + calificacion +
                ", comentario='" + comentario + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
