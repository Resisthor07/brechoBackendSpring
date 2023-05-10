package live.flordafronteira.backend.brechoBackEnd.service;


import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataService;
import live.flordafronteira.backend.brechoBackEnd.entity.Tipo;
import live.flordafronteira.backend.brechoBackEnd.repository.TipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService extends AbstrataService<TipoRepository, Tipo> {


    @Override
    public String validaObjeto(Tipo objetoParam) {
        return null;
    }

    @Override
    public boolean consultaEmBancoVinculoComTabelas(Long id) {
        return false;
    }

    @Override
    public List<Tipo> consultaEmBancoAtivos() {
        return null;
    }

    @Override
    public Tipo aplicaRegrasDeNegocio(Tipo objetoParam) {
        return objetoParam;
    }

    @Override
    public Tipo filtraDados(Tipo objetoParam) {
        return objetoParam;
    }
}
