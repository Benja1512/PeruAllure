package com.PeruAllure.PeruAllure.tienda.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false) // Specify the column for the foreign key
    @NotNull(message = "El usuario no puede ser nulo")
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido") // Specify the owning side if necessary
    @NotNull(message = "La lista de productos no puede ser nula")
    private List<Producto> productos;

    @NotNull(message = "El estado no puede estar vacío")
    @Size(min = 1, max = 50, message = "El estado debe tener entre 1 y 50 caracteres")
    @Column(nullable = false, length = 50)
    private String estado;

    @NotNull(message = "El total no puede ser nulo")
    @Positive(message = "El total debe ser mayor que cero")
    @Column(nullable = false)
    private double total;

    // Constructor vacío
    public Pedido() {}

    // Constructor con argumentos
    public Pedido(Long id, Usuario usuario, List<Producto> productos, String estado, double total) {
        this.id = id;
        this.usuario = usuario;
        this.productos = productos;
        this.estado = estado;
        this.total = total;
    }

    // Getters y Setters
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", productos=" + productos +
                ", estado='" + estado + '\'' +
                ", total=" + total +
                '}';
    }
}
