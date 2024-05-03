package com.ipn.mx.ApiInventarioMini.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombreProducto;
    private String descripcionProducto;
    private double precio;
    private int existencia;
    private int idCategoria;
}
