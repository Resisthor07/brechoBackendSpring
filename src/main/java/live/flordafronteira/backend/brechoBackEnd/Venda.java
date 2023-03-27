package live.flordafronteira.backend.brechoBackEnd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vendas",schema = "public")
public class Venda extends Entitty{



    @Enumerated(EnumType.STRING)
    @Getter @Setter
    @Column(name = "forma_do_pagamento", length = 15, nullable = false)
    private FormaPagamento pagamento;
    @Getter @Setter
    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Getter @Setter
    @Column(name = "validacao_do_pagamento", nullable = false)
    private boolean validacaoPagamento;

    @Getter @Setter
    @Column(name = "data_da_entrega", nullable = false)
    private LocalDateTime dataDaEntrega;

    @Getter @Setter
    @Column(name = "data_da_venda", nullable = false)
    private LocalDateTime dataDaVenda;

    @Getter @Setter
    @Column(name = "confirmacao_da_venda", nullable = false)
    private boolean confirmacaoDaVenda;

    @Getter @Setter
    @Column(name = "confirmacao_da_entrega", nullable = false)
    private boolean confirmacaoDaEntrega;


}
