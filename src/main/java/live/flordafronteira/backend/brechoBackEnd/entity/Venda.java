package live.flordafronteira.backend.brechoBackEnd.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_vendas",schema = "public")
public class Venda extends Entidade {
    @Getter @Setter
    @NotNull
    @JoinColumn(name="co_produto", referencedColumnName = "id", nullable = false)
    @ManyToMany
    private List<Produto> produto;
    @Getter @Setter
    @NotNull
    @JoinColumn(name = "co_cliente", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Cliente cliente;
    @Getter @Setter
    @NotNull
    @Column(name = "total", nullable = false)
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Getter @Setter
    @Column(name = "forma_do_pagamento", nullable = false)
    private FormaPagamento pagamento;

    @Getter @Setter
    @Column(name = "st_pagamento")
    private boolean validacaoPagamento;

    @Getter @Setter
    @NotNull
    @Column(name = "dt_entrega")
    private LocalDateTime dataDaEntrega;

    @Getter @Setter
    @NotNull
    @Column(name = "dt_venda", nullable = false)
    private LocalDateTime dataDeVenda;

    @Getter @Setter
    @Column(name = "st_venda")
    private boolean confirmacaoDaVenda;

    @Getter @Setter
    @Column(name = "st_entrega")
    private boolean confirmacaoDaEntrega;

}
