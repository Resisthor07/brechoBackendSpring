package live.flordafronteira.backend.brechoBackEnd.Entity;

import jakarta.persistence.*;
import live.flordafronteira.backend.brechoBackEnd.Entity.Entidade;
import live.flordafronteira.backend.brechoBackEnd.View.Entity.Cliente;
import live.flordafronteira.backend.brechoBackEnd.View.Entity.FormaPagamento;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@jakarta.persistence.Entity
@Table(name = "vendas",schema = "public")
public class Venda extends Entidade {
    @Getter @Setter
    @JoinColumn(name="co_produto", referencedColumnName = "id")
    @ManyToMany
    private List<Produto> produto;
    @Getter @Setter
    @JoinColumn(name = "co_cliente", referencedColumnName = "id")
    @ManyToOne
    private Cliente cliente;
    @Getter @Setter
    @Column(name = "total", nullable = false)
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    @Column(name = "forma_do_pagamento", length = 15, nullable = false)
    private FormaPagamento pagamento;

    @Getter @Setter
    @Column(name = "validacao_do_pagamento")
    private boolean validacaoPagamento;

    @Getter @Setter
    @Column(name = "data_da_entrega")
    private LocalDateTime dataDaEntrega;

    @Getter @Setter
    @Column(name = "data_da_venda", nullable = false)
    private LocalDateTime dataDaVenda;


    @Getter @Setter
    @Column(name = "confirmacao_da_venda")
    private boolean confirmacaoDaVenda;

    @Getter @Setter
    @Column(name = "confirmacao_da_entrega")
    private boolean confirmacaoDaEntrega;


}
