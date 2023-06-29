package live.flordafronteira.backend.brechoBackEnd.service;

import jakarta.validation.constraints.AssertFalse;
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
        venda.setTotal(calculaTotal(venda));
        venda.setDataDeVenda(confirmaVenda(venda));
        venda.setDataDaEntrega(confirmaEntrega(venda));
        return venda;
    }
    @Override
    public Venda filtraDados(Venda venda) {
        return venda;
    }
    /*
    *Verifica se o produto ja esta com a data de entrega, caso nao estiver atribui a data atual.*/
    @Transactional
    public LocalDateTime confirmaEntrega(Venda venda){
        if(venda.isConfirmacaoDaEntrega() && venda.getDataDaEntrega() != null){
            descontaOsProdutosDoEstoque(venda);
            return venda.getDataDaEntrega();
        } else if( venda.isConfirmacaoDaEntrega() && venda.getDataDaEntrega() == null){
            descontaOsProdutosDoEstoque(venda);
            return LocalDateTime.now();
        }
        return null;
    }
    public void descontaOsProdutosDoEstoque(Venda venda){
        venda.getProdutos().forEach(produto -> {
            repository.atualizaEstoqueDoProduto(produto.getId(), produto.getQuantidade());
        });
    }
    public LocalDateTime confirmaVenda(Venda venda){
        if(venda.isConfirmacaoDaVenda() && venda.getDataDeVenda() != null){

            return venda.getDataDaEntrega();
        } else if( venda.isConfirmacaoDaVenda() && venda.getDataDeVenda() == null){
            return LocalDateTime.now();
        }
        return null;
    }
    public BigDecimal calculaTotal(Venda venda){
        BigDecimal total = new BigDecimal(0);
        venda.getProdutos().forEach((produto -> {
            Assert.isTrue(produtoRepositorio.existsById(produto.getId()), "O produto "
                    + produto.getNome()
                    + " nao existe no banco de dados.");
            total.add(produto
                    .getValorAtual()
                    .multiply(new BigDecimal(produto.getQuantidade())));
        }));
        return total;
    }
}
