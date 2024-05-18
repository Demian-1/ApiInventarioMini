package com.ipn.mx.ApiInventarioMini.integration;


import com.ipn.mx.ApiInventarioMini.domain.dto.ProductosCategoria;
import com.ipn.mx.ApiInventarioMini.domain.entity.Categoria;
import com.ipn.mx.ApiInventarioMini.domain.entity.Producto;
import com.ipn.mx.ApiInventarioMini.service.CategoriaServiceImpl;
import com.ipn.mx.ApiInventarioMini.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Optional<Producto> producto = productoService.findById(id);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/categoria/{categoriaId}")
    public ResponseEntity<Producto> createProductoForCategoria(@PathVariable Integer categoriaId, @RequestBody Producto producto) {
        Optional<Categoria> optionalCategoria = categoriaService.findById(categoriaId);
        if (optionalCategoria.isPresent()) {
            Categoria categoria = optionalCategoria.get();
            producto.setCategoria(categoria);
            Producto nuevoProducto = productoService.save(producto);
            return ResponseEntity.ok(nuevoProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Optional<Producto> optionalProducto = productoService.findById(id);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            producto.setNombreProducto(productoDetails.getNombreProducto());
            producto.setDescripcionProducto(productoDetails.getDescripcionProducto());
            producto.setPrecio(productoDetails.getPrecio());
            producto.setExistencia(productoDetails.getExistencia());
            return ResponseEntity.ok(productoService.save(producto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/porCategoria")
    public ResponseEntity<List<ProductosCategoria>> getProductosPorCategoria() {
        List<ProductosCategoria> res = productoService.productoPorCategoria();
        return ResponseEntity.ok(res);
    }
}