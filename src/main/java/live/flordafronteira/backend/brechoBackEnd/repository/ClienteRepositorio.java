package live.flordafronteira.backend.brechoBackEnd.repository;

import live.flordafronteira.backend.brechoBackEnd.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Repository
public interface ClienteRepositorio extends JpaRepository <Cliente, Long> {
    @Query("SELECT COUNT(*)>0 FROM Cliente cliente where cliente.id = :id")
    public boolean checaId(@RequestParam("id") Long id);

    @Query("SELECT count(*)>0 from Cliente cliente where cliente.telefone = :telefone")
            public boolean checaTelefone(@PathVariable("telefone") String telefone);
    @Query("SELECT count(*)>0 from Cliente cliente where cliente.email = :email")
    public boolean checaEmail(@PathVariable("email") String email);
}
