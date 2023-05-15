package live.flordafronteira.backend.brechoBackEnd.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.internal.ImmutableEntityEntry;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produto", schema = "public")
public class Produto extends Entidade {

    @Getter @Setter
    @Column(name = "co_produto", nullable = false, unique = true, length = 20)
    @NotBlank(message = "Código é obrigatório!")
    private String codigo;
    @Getter @Setter
    @Column(name = "no_produto", nullable = false, length = 30)
    @NotBlank(message = "Nome é obrigatório!")
    private String nome;
    @Getter @Setter
    @JoinColumn(name = "co_tipo_produto", referencedColumnName = "id")
    @ManyToOne
    @NotNull(message = "Tipo é obrigatório!")
    private Tipo tipo;
    @Getter @Setter
    @Column(name = "no_cor", length = 50)
    @NotBlank(message = "Cor é obrigatório!")
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
    @NotEmpty(message = "Descrição não deve conter espaço vazio!")
    private String descricao;
    @Getter @Setter
    @Column(name = "no_marca", nullable = false, length=100)
    @NotBlank(message = "Marca é obrigatório!")
    private String marca;
    @Getter @Setter
    @Column(name = "st_disponibilidade", nullable = false)
    @NotNull(message = "Disponibilidade é obrigatório!")
    private boolean disponibilidade;
    @Getter @Setter
    @Column(name = "qt-produto", nullable = false)
    @NotBlank(message = "Quantidade é obrigatório!")
    private int quantidade;
    @Getter @Setter
    @Column(name="vl_anterior")
    private BigDecimal valorAnterior;
    @Getter @Setter
    @Column(name = "st_promocao", nullable = false)
    @NotBlank(message = "Campo em promoção é obrigatório!")
    private boolean emPromocao;

}
