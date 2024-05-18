package com.ipn.mx.ApiInventarioMini.service;

import com.ipn.mx.ApiInventarioMini.domain.dto.ProductosCategoria;
import com.ipn.mx.ApiInventarioMini.domain.entity.Producto;
import com.ipn.mx.ApiInventarioMini.domain.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductosCategoria> productoPorCategoria() {
        List<Object[]> resultados = repository.contarProductoPorCategoria();
        List<ProductosCategoria> lista = new ArrayList<>();
        for(Object[] registro : resultados){
            ProductosCategoria pc = new ProductosCategoria();
            pc.setCategoria((String)registro[0]);
            pc.setCantidad((Long)registro[1]);
            lista.add(pc);
        }

        return lista;
    }

    @Override
    public List<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
