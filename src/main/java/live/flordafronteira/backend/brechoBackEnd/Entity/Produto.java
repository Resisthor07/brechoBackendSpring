package live.flordafronteira.backend.brechoBackEnd.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produto", schema = "public")
public class Produto extends Entidade {

    @Getter @Setter
    @Column(name = "co_produto", nullable = false, unique = true, length = 20)
    private String codigo;
    @Getter @Setter
    @Column(name = "no_produto", nullable = false, length = 30)
    private String nome;
    @Getter @Setter
   @JoinColumn(name = "co_tipo_produto", referencedColumnName = "id")
    @ManyToOne
   private Tipo tipo;
    @Getter @Setter
    @Column(name = "no_cor", length = 50)
    private String cor;
    @Getter @Setter
    @Column(name = "no_tamanho", nullable = false, length = 5)
    private String tamanho;
    @Getter @Setter
    @Column(name = "vl_atual", nullable = false)
    private BigDecimal valorAtual;
    @Getter @Setter
    @Column(name = "imagem")//colocar os anotation da JoinTable
    @OneToMany
    private List<Foto> fotosDoProduto;
    @Getter @Setter
    @Column(name = "ds_produto", length = 500)
    private String descricao;
    @Getter @Setter
    @Column(name = "no_marca", nullable = false, length=100)
    private String marca;
    @Getter @Setter
    @Column(name = "st_disponibilidade", nullable = false)
    private boolean disponibilidade;
    @Getter @Setter
    @Column(name = "qt-produto", nullable = false)
    private int quantidade;
    @Getter @Setter
    @Column(name="vl_anterior")
    private BigDecimal valorAnterior;
    @Getter @Setter
    @Column(name = "st_promocao", nullable = false)
    private boolean emPromocao;


}
