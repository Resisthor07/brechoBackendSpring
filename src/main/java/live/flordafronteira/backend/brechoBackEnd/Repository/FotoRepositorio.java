package live.flordafronteira.backend.brechoBackEnd.Repository;

import live.flordafronteira.backend.brechoBackEnd.Entity.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepositorio extends JpaRepository<Foto, Long> {
}
