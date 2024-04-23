package com.ipn.mx.ApiInventarioMini.integration;


import com.ipn.mx.ApiInventarioMini.domain.dto.ProductosCategoria;
import com.ipn.mx.ApiInventarioMini.domain.entity.Producto;
import com.ipn.mx.ApiInventarioMini.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiProducto")
public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return service.findAll();
    }

    @GetMapping("/productosPorCategoria")
    public List<ProductosCategoria> getProductosPorCategoria() {
        return service.productoPorCategoria();
    }
}
