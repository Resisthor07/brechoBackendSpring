package live.flordafronteira.backend.brechoBackEnd.service;

import live.flordafronteira.backend.brechoBackEnd.entity.Cliente;
import live.flordafronteira.backend.brechoBackEnd.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ClienteService {
    @Autowired
    private ClienteRepositorio repository;

    @Transactional(rollbackFor = Exception.class)
    public void cadastraCliente(final Cliente cliente){
        if(cliente.getId() == null || cliente.getId()<1){
            throw new RuntimeException("ID Inválido.");
        }else if(repository.checaId(cliente.getId())){
            throw new RuntimeException("Este ID já está em uso.");
        }
    }


}
