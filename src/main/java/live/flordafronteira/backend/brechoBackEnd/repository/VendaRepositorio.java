package live.flordafronteira.backend.brechoBackEnd.repository;

import live.flordafronteira.backend.brechoBackEnd.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepositorio extends JpaRepository <Venda, Long> {
}
