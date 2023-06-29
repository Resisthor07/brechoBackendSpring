package live.flordafronteira.backend.brechoBackEnd.repository;

import live.flordafronteira.backend.brechoBackEnd.entity.Produto;
import live.flordafronteira.backend.brechoBackEnd.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface VendaRepository extends JpaRepository <Venda, Long> {
    @Query(value = "SELECT p.quantidade FROM Produto p WHERE p.id = :id AND p.status")
    int quantidadeEmEstoque(@Param("id") Long id);
    @Query(value = "SELECT p.disponibilidade FROM Produto p WHERE p.id = :id AND p.status")
    boolean verificaDisponibilidade(@Param("id") Long id);
    @Modifying
    @Query(value = "UPDATE Produto p SET p.quantidade = (p.quantidade - :quantidade WHERE p.id = :id)")
    void atualizaEstoqueDoProduto(@Param("id") Long id, @Param("quantidade") int quantidade);
}
