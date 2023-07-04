package live.flordafronteira.backend.brechoBackEnd.service;

import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataService;
import live.flordafronteira.backend.brechoBackEnd.entity.Administrador;
import live.flordafronteira.backend.brechoBackEnd.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdministradorService extends AbstrataService<AdministradorRepository, Administrador> {
    private final AdministradorRepository administradorRepository;

    @Autowired
    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    public boolean autenticar(String login, String senha) {
        Administrador administrador = administradorRepository.findByLogin(login);

        if (administrador != null && administrador.getSenha().equals(senha)) {
            return true; // Autenticação bem-sucedida
        } else {
            return false; // Credenciais inválidas
        }
    }
    @Override
    public String validaObjeto(Administrador administrador) {

         if (administrador.getLogin() == null) {
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
    public Administrador filtraDados(Administrador administrador) {

        return administrador;
    }
}
