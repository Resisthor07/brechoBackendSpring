package live.flordafronteira.backend.brechoBackEnd.Repository;

import live.flordafronteira.backend.brechoBackEnd.Entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//quando for chave composta é indicado fazer uma classe e informar aqui
public interface VendaRepositorio extends JpaRepository <Venda, Long> {
}
