package com.peruallure.peruallure.tienda.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "compra")
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario; // Relación con el usuario que realizó la compra

    @Column(nullable = false)
    private Double total; // Total de la compra

    @Column(nullable = false)
    private LocalDate fechaCompra; // Fecha de la compra

    @Column(nullable = false)
    private String productos; // Lista de productos comprados (puede ser un JSON o una relación con productos)

    @Column(nullable = true)
    private String metodoDePago; // Método de pago utilizado (tarjeta, PayPal, etc.)

    // Constructor vacío
    public Compra() {}

    // Constructor con parámetros
    public Compra(Usuario usuario, Double total, LocalDate fechaCompra, String productos, String metodoDePago) {
        this.usuario = usuario;
        this.total = total;
        this.fechaCompra = fechaCompra;
        this.productos = productos;
        this.metodoDePago = metodoDePago;
    }

    // Métodos Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", usuario=" + usuario.getNombre() +
                ", total=" + total +
                ", fechaCompra=" + fechaCompra +
                ", productos='" + productos + '\'' +
                ", metodoDePago='" + metodoDePago + '\'' +
                '}';
    }
}
