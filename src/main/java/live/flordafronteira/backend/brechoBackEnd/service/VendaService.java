package live.flordafronteira.backend.brechoBackEnd.service;

import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataService;
import live.flordafronteira.backend.brechoBackEnd.entity.Venda;
import live.flordafronteira.backend.brechoBackEnd.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService extends AbstrataService<VendaRepository, Venda> {
    @Override
    public String validaObjeto(Venda venda) {
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
        return venda;
    }

    @Override
    public Venda filtraDados(Venda venda) {
        return venda;
    }
}
