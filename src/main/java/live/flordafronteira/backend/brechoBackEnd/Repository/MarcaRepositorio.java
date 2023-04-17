package live.flordafronteira.backend.brechoBackEnd.Repository;

import live.flordafronteira.backend.brechoBackEnd.View.Entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepositorio extends JpaRepository<Marca, Long> {
}
