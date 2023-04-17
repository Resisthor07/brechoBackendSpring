package live.flordafronteira.backend.brechoBackEnd.Repository;

import live.flordafronteira.backend.brechoBackEnd.View.Entity.TipoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProdutoRepositorio extends JpaRepository <TipoProduto, Long> {
}
