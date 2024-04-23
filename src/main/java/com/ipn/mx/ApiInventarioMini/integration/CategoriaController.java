package com.ipn.mx.ApiInventarioMini.integration;

import com.ipn.mx.ApiInventarioMini.domain.entity.Categoria;
import com.ipn.mx.ApiInventarioMini.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias(){
        try{
            List<Categoria> categoriaList = categoriaService.findAll();
            if(categoriaList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categoriaList, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Integer id){
        try{
            Optional<Categoria> categoriaData = categoriaService.findById(id);

            // return categoriaData.map(categoria -> new ResponseEntity<>(categoria, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
            if(categoriaData.isPresent()){
                return new ResponseEntity<>(categoriaData.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Categoria> addCategoria(@RequestBody Categoria categoria){
        try{
            Categoria resp = categoriaService.save(categoria);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria){
        try{
            Optional<Categoria> categoriaData = categoriaService.findById(id);

            if(categoriaData.isPresent()){
                Categoria categoriaUpdate = categoriaData.get();
                categoriaUpdate.setNombreCategoria(categoria.getNombreCategoria());
                categoriaUpdate.setDescripcionCategoria(categoria.getDescripcionCategoria());

                Categoria resp = categoriaService.save(categoriaUpdate);
                return  new ResponseEntity<>(resp, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> deleteCategoria(@PathVariable Integer id){
        try{
            categoriaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
