package com.ipn.mx.ApiInventarioMini.domain.repository;

import com.ipn.mx.ApiInventarioMini.domain.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepo extends JpaRepository<Categoria, Integer> {
}

/*
delimiter $$
create procedure spProductosCategoria()
begin
    select c.nombre_categoria as categoria, count(*) as cantidad from Producto p, Categoria as c where c.idCategoria = p.idCategoria group by c.idCategoria;
end $$
delimiter ;
 */


/*
CREATE OR REPLACE FUNCTION spProductosCategoria()
RETURNS TABLE(categoria VARCHAR, cantidad bigint) AS $$
BEGIN
RETURN QUERY
SELECT c.nombre_categoria as categoria, COUNT(*) as cantidad
FROM Producto p
JOIN Categoria c ON c.idCategoria = p.idCategoria
GROUP BY c.idCategoria;
END;
$$ LANGUAGE plpgsql;

DROP FUNCTION spproductoscategoria();


SELECT * FROM spProductosCategoria();
*/
