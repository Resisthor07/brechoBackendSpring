package live.flordafronteira.backend.brechoBackEnd.repository;

import live.flordafronteira.backend.brechoBackEnd.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {
//
//    @Query("select exists (select p from Produto p where p.tipo.id = :id)")
//    boolean isInProduto(@Param("id") final Long id);
//
//    @Query("select t from Tipo t where t.status = true")
//    List<Tipo> findByAtivo();
}
