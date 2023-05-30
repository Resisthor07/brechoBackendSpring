package live.flordafronteira.backend.brechoBackEnd.service;

import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataService;
import live.flordafronteira.backend.brechoBackEnd.entity.Administrador;
import live.flordafronteira.backend.brechoBackEnd.repository.AdministradorRepository;

import java.util.List;

public class AdministradorService extends AbstrataService<AdministradorRepository, Administrador> {
    @Override
    public String validaObjeto(Administrador administrador) {
        if(administrador.getNome() == null){
            return "NOME NULO";
        } else if (administrador.getEmail() == null) {
            return "EMAIL NULO";
        } else if (administrador.getLogin() == null) {
            return "LOGIN NULO";
        } else if (administrador.getSenha() == null) {
            return "SENHA NULA";
        }

        return null;
    }

    @Override
    public boolean consultaEmBancoVinculoComTabelas(Long id) {
        return false;
    }

    @Override
    public List<Administrador> consultaEmBancoAtivos() {
        return null;
    }

    @Override
    public Administrador aplicaRegrasDeNegocio(Administrador administrador) {
        return administrador;
    }

    @Override
    public Administrador filtraDados(Administrador objetoParam) {
        return null;
    }
}
