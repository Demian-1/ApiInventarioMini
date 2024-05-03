package com.ipn.mx.ApiInventarioMini.integration;


import com.ipn.mx.ApiInventarioMini.domain.dto.ProductoDTO;
import com.ipn.mx.ApiInventarioMini.domain.dto.ProductosCategoria;
import com.ipn.mx.ApiInventarioMini.domain.entity.Producto;
import com.ipn.mx.ApiInventarioMini.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiProducto")
public class ProductoController {
    @Autowired
    private ProductoService service;
    @Autowired
    private CategoriaController categoriaController;

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getProductos() {
        try{
            List<Producto> productoList = service.findAll();
            if(productoList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productoList, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productosPorCategoria")
    public ResponseEntity<List<ProductosCategoria>> getProductosPorCategoria() {
        try {
            List<ProductosCategoria> prodCategoList = service.productoPorCategoria();
            if(prodCategoList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(prodCategoList, HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> getProducto(@PathVariable Integer id) {
        try {
            Optional<Producto> p = service.findById(id);
            if(p.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(p.get(), HttpStatus.OK);
            }
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/producto")
    public ResponseEntity<Producto> addProducto(@Valid @RequestBody ProductoDTO producto) {
        try {
            Producto resp = service.save(producto);
            return new ResponseEntity<>(resp, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/producto/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Integer id,@RequestBody ProductoDTO producto) {
        try{
            Producto p = service.update(Long.valueOf(id), producto);
            if(p == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                return new ResponseEntity<>(p, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/producto/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable Integer id){
        try {
            Optional<Producto> res = service.findById(id);
            if(res.isPresent()){
                service.deleteById(res.get());
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
