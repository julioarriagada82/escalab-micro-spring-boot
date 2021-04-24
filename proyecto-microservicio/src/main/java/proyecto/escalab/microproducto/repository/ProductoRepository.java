package proyecto.escalab.microproducto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.escalab.microproducto.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {

}
