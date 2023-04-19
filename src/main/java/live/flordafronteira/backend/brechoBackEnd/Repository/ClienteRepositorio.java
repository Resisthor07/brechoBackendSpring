package live.flordafronteira.backend.brechoBackEnd.Repository;

import live.flordafronteira.backend.brechoBackEnd.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepositorio extends JpaRepository <Cliente, Long> {
}
