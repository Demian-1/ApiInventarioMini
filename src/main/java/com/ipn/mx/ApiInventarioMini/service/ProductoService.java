package com.ipn.mx.ApiInventarioMini.service;

import java.util.List;

import com.ipn.mx.ApiInventarioMini.domain.dto.ProductosCategoria;
import com.ipn.mx.ApiInventarioMini.domain.entity.Producto;

public interface ProductoService {
    public List<ProductosCategoria> productoPorCategoria();

    public List<Producto> findAll();
    public Producto findById(int id);
    public Producto save(Producto producto);
    public void deleteById(Producto producto);
}
