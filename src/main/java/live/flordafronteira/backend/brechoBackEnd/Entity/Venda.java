package live.flordafronteira.backend.brechoBackEnd.Entity;

import jakarta.persistence.*;
import live.flordafronteira.backend.brechoBackEnd.Entity.Entidade;
import live.flordafronteira.backend.brechoBackEnd.Entity.Cliente;
import live.flordafronteira.backend.brechoBackEnd.Entity.FormaPagamento;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_vendas",schema = "public")
public class Venda extends Entidade {
    @Getter @Setter
    @JoinColumn(name="co_produto", referencedColumnName = "id", nullable = false)
    @ManyToMany
    private List<Produto> produto;
    @Getter @Setter
    @JoinColumn(name = "co_cliente", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Cliente cliente;
    @Getter @Setter
    @Column(name = "total", nullable = false)
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
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
    @Column(name = "dt_venda", nullable = false)
    private LocalDateTime dataDeVenda;


    @Getter @Setter
    @Column(name = "st_venda")
    private boolean confirmacaoDaVenda;

    @Getter @Setter
    @Column(name = "st_entrega")
    private boolean confirmacaoDaEntrega;


}
