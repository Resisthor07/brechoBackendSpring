package live.flordafronteira.backend.brechoBackEnd.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_vendas",schema = "public")
public class Venda extends Entidade {
    @Getter @Setter
    @OneToMany
//    @NotNull(message = "A venda deve conter um ou mais produtos.")
    @JoinColumn(name="id_produto", referencedColumnName = "id", nullable = true)
    private List<Produto> produtos;
    @Getter @Setter
//    @NotNull(message = "A venda deve conter um cliente.")
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = true)
    @ManyToOne
    private Cliente cliente;
    @Getter @Setter
    @Column(name = "total", nullable = false)
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "A forma de pagamento deve ser preenchida.")
    @Getter @Setter
    @Column(name = "forma_do_pagamento", nullable = false)
    private FormaPagamento pagamento;
    @Getter @Setter
    @Column(name = "st_pagamento")
    private boolean validacaoPagamento;
    @Getter @Setter
    @Column(name = "dt_entrega")
    private LocalDateTime dataDaEntrega;
    @Getter @Setter
    @PastOrPresent(message = "A data de venda nao pode estar no futuro.")
//    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}", message = "Formato inválido para a data de venda.")
    @Column(name = "dt_venda")
    private LocalDateTime dataDeVenda;
    @Getter @Setter
    @Column(name = "st_venda")
    private boolean confirmacaoDaVenda;
    @Getter @Setter
    @Column(name = "st_entrega")
    private boolean confirmacaoDaEntrega;

    @Getter @Setter
    @Column(name = "st_troco_cliente")
    private BigDecimal trocoDoCliente;

    @Getter @Setter
    @Column(name = "st_dinheiro_cliente")
    private BigDecimal dinheiroFornecidoPeloCliente;
}
