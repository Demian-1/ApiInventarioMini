package com.ipn.mx.ApiInventarioMini.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(name = "nombre_categoria", length = 100, nullable = false)
    private String nombreCategoria;

    @Column(name = "descripcion_categoria", length = 250, nullable = false)
    private String descripcionCategoria;

//    @JsonIgnoreProperties(
//            value = {
//                    "idProducto",
//                    "hibernateLzyInitializer",
//                    "handler"
//            },
//            allowSetters = true
//    )
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Producto> productos;

}
