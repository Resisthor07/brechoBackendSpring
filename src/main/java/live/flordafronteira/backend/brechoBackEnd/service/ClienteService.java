package live.flordafronteira.backend.brechoBackEnd.service;

import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataService;
import live.flordafronteira.backend.brechoBackEnd.entity.Cliente;
import live.flordafronteira.backend.brechoBackEnd.repository.ClienteRepositorio;
import live.flordafronteira.backend.brechoBackEnd.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service

public class ClienteService extends AbstrataService<ClienteRepositorio, Cliente> {

    @Override
    public String validaObjeto(Cliente objetoParam) {
        return null;
    }

    @Override
    public boolean consultaEmBancoVinculoComTabelas(Long id) {
        return false;
    }

    @Override
    public List<Cliente> consultaEmBancoAtivos() {
        return null;
    }

    @Override
    public Cliente aplicaRegrasDeNegocio(Cliente cliente) {
        return cliente;
    }

    @Override
    public Cliente filtraDados(Cliente cliente) {
        return cliente;
    }
}




