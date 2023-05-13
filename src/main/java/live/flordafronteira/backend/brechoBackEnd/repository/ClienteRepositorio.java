package live.flordafronteira.backend.brechoBackEnd.repository;

import live.flordafronteira.backend.brechoBackEnd.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;


@Repository
public interface ClienteRepositorio extends JpaRepository <Cliente, Long> {
    @Query("SELECT COUNT(*)>0 FROM Cliente cliente where cliente.id = :id")
    public boolean checaId(@RequestParam("id") Long id);
}
