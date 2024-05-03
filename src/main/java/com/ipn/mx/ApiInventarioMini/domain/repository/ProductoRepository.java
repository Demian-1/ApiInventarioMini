package com.ipn.mx.ApiInventarioMini.domain.repository;

import com.ipn.mx.ApiInventarioMini.domain.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query(value = "call spProductosCategoria()", nativeQuery = true)
    public List<Object[]> contarProductoPorCategoria();
}
