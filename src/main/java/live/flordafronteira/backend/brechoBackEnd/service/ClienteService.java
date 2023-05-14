package live.flordafronteira.backend.brechoBackEnd.service;

import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataService;
import live.flordafronteira.backend.brechoBackEnd.entity.Cliente;
import live.flordafronteira.backend.brechoBackEnd.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service

public class ClienteService extends AbstrataService<ClienteRepositorio, Cliente> {


    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Transactional(rollbackFor = Exception.class)
    public void cadastraCliente(final Cliente cliente){
        if(cliente.getId() == null || cliente.getId()<1){
            throw new RuntimeException("ID Inválido.");
        }else if(this.clienteRepositorio.checaId(cliente.getId())){
            throw new RuntimeException("Este ID já está em uso.");
        }  else if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new RuntimeException("Nome de cliente inválido.");
        } else if (cliente.getNome().length()<15) {
            throw new RuntimeException("O nome do cliente deve ter no mínimo 15 caracteres.");
        } else if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) {
            throw new RuntimeException("Telefone inválido.");
        } else if (repository.checaTelefone(cliente.getTelefone())) {
            throw new RuntimeException("Este telefone já está cadastrado em outro cliente. Por favor informe outro númeor de telefone");
        } else if (cliente.getTelefone().matches("^\\([0-9]{2}\\[0-9]{5}-[0-9]{4}$|^\\([0-9]{2}\\)[0-9]{4}-[0-9]{4}$")) {
            throw new RuntimeException("O formato do telefone deve ser (00)9999-8888 ou (00)3542-1234");
        } else if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
            throw new RuntimeException("E-mail não informado.");
        } else if (repository.checaEmail(cliente.getEmail())) {
            throw new RuntimeException("Email já cadastrado em outro cliente. Informe outro email.");
        } else if (cliente.getCep() == null || cliente.getCep().isEmpty()) {
            throw new RuntimeException("CEP não informado.");
        } else if (cliente.getBairro() ==null || cliente.getBairro().isEmpty()) {
            throw new RuntimeException("Bairro não informado.");
        } else if (cliente.getLogradouro()==null || cliente.getLogradouro().isEmpty()) {
            throw new RuntimeException("Logradouro não informado.");
        } else if (cliente.getNumResidencia() == null ||
                cliente.getNumResidencia().isEmpty()) {
            throw new RuntimeException("O núnero da residência deve ser informado.");
        }
        else {
            clienteRepositorio.save(cliente);
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void atualizarCliente(@RequestParam("id")Long id, @RequestBody Cliente cliente){
        if(cliente.getId() == null || cliente.getId()<1){
            throw new RuntimeException("ID Inválido.");
        }else if(this.clienteRepositorio.checaId(cliente.getId())){
            throw new RuntimeException("Este ID já está em uso.");
        }  else if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new RuntimeException("Nome de cliente inválido.");
        } else if (cliente.getNome().length()<15) {
            throw new RuntimeException("O nome do cliente deve ter no mínimo 15 caracteres.");
        } else if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) {
            throw new RuntimeException("Telefone inválido.");
        } else if (repository.checaTelefone(cliente.getTelefone())) {
            throw new RuntimeException("Este telefone já está cadastrado em outro cliente. Por favor informe outro númeor de telefone");
        } else if (cliente.getTelefone().matches("^\\([0-9]{2}\\[0-9]{5}-[0-9]{4}$|^\\([0-9]{2}\\)[0-9]{4}-[0-9]{4}$")) {
            throw new RuntimeException("O formato do telefone deve ser (00)9999-8888 ou (00)3542-1234");
        } else if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
            throw new RuntimeException("E-mail não informado.");
        } else if (repository.checaEmail(cliente.getEmail())) {
            throw new RuntimeException("Email já cadastrado em outro cliente. Informe outro email.");
        } else if (cliente.getCep() == null || cliente.getCep().isEmpty()) {
            throw new RuntimeException("CEP não informado.");
        } else if (cliente.getBairro() ==null || cliente.getBairro().isEmpty()) {
            throw new RuntimeException("Bairro não informado.");
        } else if (cliente.getLogradouro()==null || cliente.getLogradouro().isEmpty()) {
            throw new RuntimeException("Logradouro não informado.");
        } else if (cliente.getNumResidencia() == null ||
                cliente.getNumResidencia().isEmpty()) {
            throw new RuntimeException("O núnero da residência deve ser informado.");
        }
        else {
            clienteRepositorio.save(cliente);
        }
    }
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




