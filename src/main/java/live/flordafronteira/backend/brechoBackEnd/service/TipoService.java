package live.flordafronteira.backend.brechoBackEnd.service;


import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataService;
import live.flordafronteira.backend.brechoBackEnd.entity.Tipo;
import live.flordafronteira.backend.brechoBackEnd.repository.TipoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class TipoService extends AbstrataService<TipoRepository, Tipo> {


    @Override
    public String validaObjeto(Tipo objetoParam) {
        if(objetoParam.getGenero() == null)
        {
            return "Genero não pode ser nulo";
        }
        if(objetoParam.getTipoVestuario() == null)
        {
            return "Tipo de vestuario não pode ser nulo";
        }
        if(!objetoParam.getTipoVestuario().matches("[a-zA-Z\\s]{1,100}"))
        {
            return "Problema com a formatação do tipo de vestuario";
        }

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
