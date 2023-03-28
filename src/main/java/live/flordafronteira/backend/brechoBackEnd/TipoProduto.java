package live.flordafronteira.backend.brechoBackEnd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipos-de-produtos", schema = "public")
public class TipoProduto  extends Entitty{

    @Getter @Setter
    @Column(name = "genero", nullable = false, length = 10)
    private String genero;

    @Getter @Setter
    @Column(name = "tipo-de-produto", nullable = false, length = 20)
    private String tipoProduto;

    @Getter @Setter
    @Column (name = "estacao", nullable = false, length = 30)
    private String estacao;




}
