package live.flordafronteira.backend.brechoBackEnd.service;

import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataService;
import live.flordafronteira.backend.brechoBackEnd.entity.Venda;
import live.flordafronteira.backend.brechoBackEnd.repository.ProdutoRepositorio;
import live.flordafronteira.backend.brechoBackEnd.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class VendaService extends AbstrataService<VendaRepository, Venda> {
    @Autowired
    private ProdutoRepositorio produtoRepositorio;
    @Override
    public String validaObjeto(Venda venda) {
        Assert.isTrue(!(venda.getCliente() == null), "O cliente enviado nao pode ser nulo.");
        Assert.isTrue(!(venda.getProdutos() == null), "A lista de produtos nao pode ser nula.");
        venda.getProdutos().forEach((produto -> {
            boolean possuiEstoque = true;
            Assert.isTrue(produtoRepositorio.existsById(produto.getId()), "O produto "
                    + produto.getNome()
                    + " nao existe no banco de dados.");
            if(repository
                    .quantidadeEmEstoque(produto.getId()) < produto.getQuantidade()){
                possuiEstoque = false;
            }
            Assert.isTrue(possuiEstoque,
                        "O produto "
                                + produto.getNome()
                                + " nao possui estoque suficiente.");
            Assert.isTrue(repository.verificaDisponibilidade(produto.getId()),
                    "O produto "
                                + produto.getNome()
                                + " nao esta disponivel.");
        }));
        //Verifica se o valor pago pelo cliente eh maior que o valor total
//        if(venda.isConfirmacaoDaVenda()){
//            Assert.isTrue(venda.getTotal().compareTo(venda.getDinheiroFornecidoPeloCliente()) > 0
//                            && venda.isValidacaoPagamento(),
//                    "O valor total excede a quantia paga pelo cliente.");
//        }

        return null;
    }

    @Override
    public boolean consultaEmBancoVinculoComTabelas(Long id) {
        return false;
    }

    @Override
    public List<Venda> consultaEmBancoAtivos() {
        return null;
    }

    @Override
    public Venda aplicaRegrasDeNegocio(Venda venda) {
//        venda.setTotal(calculaTotal(venda));
//        venda.setDataDeVenda(confirmaVenda(venda));
//        venda.setDataDaEntrega(confirmaEntrega(venda));
//        venda.setTrocoDoCliente(calulaTrocoDoCliente(venda));
//        if(venda.isValidacaoPagamento()){
//            atualizaVendaPaga(venda);
//        }
        return null;
    }
    @Override
    public Venda filtraDados(Venda venda) {
        return venda;
    }
    /*
    Calcula o troco do cliente
     */
    public BigDecimal calulaTrocoDoCliente(Venda venda){
        if(venda.isConfirmacaoDaVenda()){
            Assert.isTrue(venda.getDinheiroFornecidoPeloCliente().subtract(venda.getTotal()).compareTo(new BigDecimal(0)) >= 0, "O valor pago deve ser igual ou superior ao valor da compra.");
            return venda.getDinheiroFornecidoPeloCliente().subtract(venda.getTotal());
        }
        return null;
    }
    /*
    *Verifica se o produto ja esta com a data de entrega, caso nao estiver atribui a data atual.*/
    public LocalDateTime confirmaEntrega(Venda venda){
        if(venda.isConfirmacaoDaEntrega() && venda.getDataDaEntrega() != null){
            return venda.getDataDaEntrega();
        } else if( venda.isConfirmacaoDaEntrega() && venda.getDataDaEntrega() == null){
            return LocalDateTime.now();
        }
        return null;
    }
    public void descontaOsProdutosDoEstoque(Venda venda){
        venda.getProdutos().forEach(produto -> {
            repository.atualizaEstoqueDoProduto(produto.getId(), produto.getQuantidade());
        });
    }
    @Transactional
    public LocalDateTime confirmaVenda(Venda venda){
        if(venda.isConfirmacaoDaVenda() && venda.getDataDeVenda() != null){
            descontaOsProdutosDoEstoque(venda);
            return venda.getDataDeVenda();
        } else if( venda.isConfirmacaoDaVenda() && venda.getDataDeVenda() == null){
            descontaOsProdutosDoEstoque(venda);
            return LocalDateTime.now();
        }
        return null;
    }
    public void atualizaVendaPaga(Venda venda){
        if(venda.isConfirmacaoDaVenda() && venda.isValidacaoPagamento()){
            repository.save(venda);
        }
    }
//    public BigDecimal calculaTotal(Venda venda){
//        AtomicReference<BigDecimal> total = new AtomicReference<>(new BigDecimal(0));
//        venda.getProdutos().forEach((produto -> {
//            BigDecimal quantidadeVendida = new BigDecimal(produto.getQuantidadeVendida());
//            Assert.isTrue(produto.getNome() != null, "Informe o nome do produto.");
//            Assert.isTrue(produtoRepositorio.existsById(produto.getId()), "O produto "
//                    + produto.getNome()
//                    + " nao existe no banco de dados.");
//            Assert.isTrue(produto.getQuantidadeVendida() > 0,"Informe a quantidade vendida." );
//            produto = produtoRepositorio.getById(produto.getId());
//            BigDecimal valorAtual = produto.getValorAtual();
//            total.set(valorAtual.multiply(quantidadeVendida));
//
//        }));
//        return total.get();
    //}
}
