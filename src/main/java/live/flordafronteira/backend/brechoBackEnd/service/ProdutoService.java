package live.flordafronteira.backend.brechoBackEnd.service;

import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataService;
import live.flordafronteira.backend.brechoBackEnd.entity.Produto;
import live.flordafronteira.backend.brechoBackEnd.repository.ProdutoRepositorio;
import live.flordafronteira.backend.brechoBackEnd.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService extends AbstrataService <ProdutoRepositorio, Produto> {
    @Autowired
    private final TipoRepository tipoRepository;

    public ProdutoService(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    @Override
    public String validaObjeto(Produto objetoParam) {
        if (!tipoRepository.existsById(objetoParam.getTipo().getId())){
            throw new RuntimeException("Tipo informado não existe!");
        }
        return null;
    }

    @Override
    public boolean consultaEmBancoVinculoComTabelas(Long id) {
        return false;
    }

    @Override
    public List<Produto> consultaEmBancoAtivos() {
        return null;
    }

    @Override
    public Produto aplicaRegrasDeNegocio(Produto objetoParam) {
        return null;
    }

    @Override
    public Produto filtraDados(Produto objetoParam) {
        return null;
    }
}
