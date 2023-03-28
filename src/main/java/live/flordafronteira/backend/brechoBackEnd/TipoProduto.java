package live.flordafronteira.backend.brechoBackEnd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_produto", schema = "public")
public class TipoProduto extends Entitty{
    @Getter @Setter
    @Column(name = "genero", nullable = false, length = 5)
    private String genero;
    @Getter @Setter
    @Column(name = "tipo_produto", nullable = false, length = 20)
    private String tipoProduto;
    @Getter @Setter
    @Column(name = "estacao", length = 20)
    private String estacao;
}
