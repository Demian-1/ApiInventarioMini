package com.ipn.mx.ApiInventarioMini.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProducto;

    @Column(name = "nombreProducto", length =50, nullable = false)
    private String nombreProducto;

    @Column(name = "descripcionProducto", length =250, nullable = false)
    private String descripcionProducto;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "existencia", nullable = false)
    private int existencia;

    private Categoria idCategoria;
}
