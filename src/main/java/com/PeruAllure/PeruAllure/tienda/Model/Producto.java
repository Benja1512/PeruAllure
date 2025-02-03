package com.PeruAllure.PeruAllure.tienda.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotNull(message = "El precio no puede ser nulo")
    @Positive(message = "El precio debe ser mayor que cero")
    @Column(nullable = false)
    private double precio;

    @Size(max = 500, message = "La descripción no puede exceder los 500 caracteres")
    @Column(length = 500)
    private String descripcion;

    @NotNull(message = "La cantidad en stock no puede ser nula")
    @Positive(message = "La cantidad en stock debe ser mayor o igual a cero")
    @Column(nullable = false)
    private int cantidadEnStock;

    @Size(max = 50, message = "La categoría no puede exceder los 50 caracteres")
    @Column(length = 50)
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido; // Nueva propiedad

    // Constructor vacío
    public Producto() {}

    // Constructor con parámetros
    public Producto(Long id, String nombre, double precio, String descripcion, int cantidadEnStock, String categoria, Pedido pedido) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidadEnStock = cantidadEnStock;
        this.categoria = categoria;
        this.pedido = pedido;
    }

    // Constructor con parámetros limitados
    public Producto(String nombre, double precio) {
        this(null, nombre, precio, null, 0, null, null);
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", cantidadEnStock=" + cantidadEnStock +
                ", categoria='" + categoria + '\'' +
                ", pedido=" + pedido + // Agregado al toString
                '}';
    }
}
