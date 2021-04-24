package proyecto.escalab.microservicio.compra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.escalab.microservicio.compra.model.Cesta;

public interface CestaRepository extends JpaRepository<Cesta,Integer>{

}
