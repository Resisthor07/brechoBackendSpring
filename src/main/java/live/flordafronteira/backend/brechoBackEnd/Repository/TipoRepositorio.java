package live.flordafronteira.backend.brechoBackEnd.Repository;

import live.flordafronteira.backend.brechoBackEnd.Entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepositorio extends JpaRepository<Tipo, Long> {
}
