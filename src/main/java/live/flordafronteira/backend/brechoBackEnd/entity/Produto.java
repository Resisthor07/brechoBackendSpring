package live.flordafronteira.backend.brechoBackEnd.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.internal.ImmutableEntityEntry;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produto", schema = "brecho")
public class Produto extends Entidade {

    @Getter @Setter
    @Column(name = "co_produto", nullable = false, unique = true, length = 20)
    @NotBlank(message = "Código não pode ser vazio!")
    @NotNull(message = "Código é obrigatório!")
    @Size(min = 1, max = 20, message = "Código não tem um tamanho valido! Min 1 e Max 20")
    private String codigo;
    @Getter @Setter
    @Column(name = "no_produto", nullable = false, length = 30)
    @NotBlank(message = "Nome não pode ser vazio!")
    @NotNull(message = "Nome é obrigatório!")
    @Size(min = 2, max = 30, message = "Nome não tem um tamanho valido! Min 2 e Max 30")
    private String nome;
    @Getter @Setter
   // @JoinColumn(name = "co_tipo_produto", referencedColumnName = "id")
    //@ManyToOne
    @NotNull(message = "Tipo é obrigatório!")
    //@NotBlank(message = "Tipo não pode ser vazio!")
    private String tipo;
    @Getter @Setter
    @Column(name = "no_cor", length = 50)
    @NotBlank(message = "Cor não pode ser vazio!")
    private String cor;
    @Getter @Setter
    @Column(name = "no_tamanho", nullable = false, length = 5)
    @NotNull(message = "Tamanho é obrigatório!")
    @NotBlank(message = "Tamanho não pode ser vazio!")
    private String tamanho;
    @Getter @Setter
    @Column(name = "vl_atual", nullable = false)
    @NotNull(message = "Valor atual é obrigatório!")
    //@NotBlank(message = "Valor atual não pode ser vazio!")
    private BigDecimal valorAtual;
    @Getter @Setter
    @Column(name = "imagem")//colocar os anotation da JoinTable
   // @OneToMany
    //@JoinTable(name = "foto_produto")
    @NotNull(message = "Valor atual é obrigatório!")
    private String fotosDoProduto;
    @Getter @Setter
    @Column(name = "ds_produto", length = 500)
    @NotBlank(message = "Descrição não deve conter somente espaço vazio!")
    @Size(min = 2, max = 500, message = "Descrição ultrapassou a quantidade de caracteres validos! Max 500")
    private String descricao;
    @Getter @Setter
    @Column(name = "no_marca", nullable = false, length=100)
    @NotNull(message = "Marca é obrigatório!")
    @NotBlank(message = "Marca não pode ser vazio!")
    private String marca;
    @Getter @Setter
    @Column(name = "st_disponibilidade", nullable = false)
    @NotNull(message = "Disponibilidade é obrigatório!")
    private boolean disponibilidade;
    @Getter @Setter
    @Column(name = "qt-produto", nullable = false)
    @NotNull(message = "Quantidade é obrigatório!")
    //@NotBlank(message = "Quantidade não pode ser vazio!")
    private int quantidade;
    @Getter @Setter
    @Column(name="vl_anterior")
    private BigDecimal valorAnterior;
    @Getter @Setter
    @Column(name = "st_promocao", nullable = false)
    @NotNull(message = "Campo em promoção é obrigatório!")
    //@NotBlank(message = "Campo em promoção não pode ser vazio!")
    private boolean emPromocao;

}
