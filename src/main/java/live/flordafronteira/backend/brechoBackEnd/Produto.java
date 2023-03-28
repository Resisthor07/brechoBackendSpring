package live.flordafronteira.backend.brechoBackEnd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produto", schema = "public")
public class Produto extends Entitty{

    @Getter @Setter
    @Column(name = "codigo", nullable = false, unique = true, length = 20)
    private String codigo;
    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 20)
    private String nome;
    @Getter @Setter
    @JoinColumn(name = "tipo_produto", nullable = false)
    @ManyToOne
    private TipoProduto tipo;
    @Getter @Setter
    @Column(name = "cor", length = 20)
    private String cor;
    @Getter @Setter
    @Column(name = "tamanho", nullable = false, length = 5)
    private String tamanho;
    @Getter @Setter
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;
    @Getter @Setter
    @Column(name = "imagem_url")
    private String imagens;
    @Getter @Setter
    @Column(name = "imagem_principal_url")
    private String imagemPrincipal;
    @Getter @Setter
    @Column(name = "descricao", length = 100)
    private String descricao;
    @Getter @Setter
    @Column(name = "marca", length = 20)
    private String marca;
    @Getter @Setter
    @Column(name = "disponibilidade")
    private boolean disponibilidade;
    @Getter @Setter
    @Column(name = "quantidade")
    private int quantidade;

}
