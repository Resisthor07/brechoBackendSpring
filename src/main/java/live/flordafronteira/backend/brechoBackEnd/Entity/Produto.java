package live.flordafronteira.backend.brechoBackEnd.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@jakarta.persistence.Entity
@Table(name = "produto", schema = "public")
public class Produto extends Entidade {

    @Getter @Setter
    @Column(name = "codigo", nullable = false, unique = true, length = 20)
    private String codigo;
    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;
    @Getter @Setter
   @JoinColumn(name = "tipo_produto", referencedColumnName = "id")
    @ManyToOne
   private Tipo tipo;
    @Getter @Setter
    @Column(name = "cor", length = 50)
    private String cor;
    @Getter @Setter
    @Column(name = "tamanho", nullable = false, length = 5)
    private String tamanho;
    @Getter @Setter
    @Column(name = "vl_atual", nullable = false)
    private BigDecimal valorAtual;
    @Getter @Setter
    @Column(name = "imagem")
    @OneToMany
    private List<Foto> imagem;
    @Getter @Setter
    @Column(name = "descricao", length = 500)
    private String descricao;
    @Getter @Setter
    @Column(name = "marca", nullable = false, length=100)
    private String marca;
    @Getter @Setter
    @Column(name = "disponibilidade", nullable = false)
    private boolean disponibilidade;
    @Getter @Setter
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    @Getter @Setter
    @Column(name="vl_anterior")
    private BigDecimal valorAnterior;
    @Getter @Setter
    @Column(name = "st_promocao", nullable = false)
    private boolean emPromocao;


}
