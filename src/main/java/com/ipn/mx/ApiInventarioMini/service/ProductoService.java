package com.ipn.mx.ApiInventarioMini.service;

import java.util.List;
import java.util.Optional;

import com.ipn.mx.ApiInventarioMini.domain.dto.ProductosCategoria;
import com.ipn.mx.ApiInventarioMini.domain.entity.Producto;

public interface ProductoService {
    List<ProductosCategoria> productoPorCategoria();

    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
    void deleteById(Long id);

}
