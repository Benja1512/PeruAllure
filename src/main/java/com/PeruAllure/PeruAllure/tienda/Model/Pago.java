package com.PeruAllure.PeruAllure.tienda.Model;

import com.PeruAllure.PeruAllure.tienda.Enum.EstadoPago;
import com.PeruAllure.PeruAllure.tienda.Enum.MetodoPago;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "pago")
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del pedido no puede ser nulo")
    @Column(nullable = false)
    private Long pedidoId;

    @NotNull(message = "El monto no puede ser nulo")
    @Positive(message = "El monto debe ser mayor que cero")
    @Column(nullable = false)
    private double monto;

    @NotNull(message = "La fecha no puede ser nula")
    @Column(nullable = false)
    private LocalDate fecha;

    @NotNull(message = "El método no puede ser nulo")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private MetodoPago metodo;

    @NotNull(message = "El estado no puede ser nulo")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private EstadoPago estado;

    // Constructor vacío
    public Pago() {}

    // Constructor con argumentos
    public Pago(Long id, Long pedidoId, double monto, LocalDate fecha, MetodoPago metodo, EstadoPago estado) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.monto = monto;
        this.fecha = fecha;
        this.metodo = metodo;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MetodoPago getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPago metodo) {
        this.metodo = metodo;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", pedidoId=" + pedidoId +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", metodo=" + metodo +
                ", estado=" + estado +
                '}';
    }
}
