package com.ipn.mx.ApiInventarioMini.service;

import com.ipn.mx.ApiInventarioMini.domain.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> findAll();

    Optional<Categoria> findById(Integer id);

    Categoria save(Categoria categoria);

    void delete(Integer id);
}
