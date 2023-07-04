package live.flordafronteira.backend.brechoBackEnd.controller;
import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataController;
import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataService;
import live.flordafronteira.backend.brechoBackEnd.entity.Cliente;
import live.flordafronteira.backend.brechoBackEnd.repository.ClienteRepositorio;


import live.flordafronteira.backend.brechoBackEnd.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/api/cliente")
@CrossOrigin
public class ClienteController extends AbstrataController<ClienteService, Cliente> {
    private ClienteService service;


    @Override
    public ResponseEntity<?> cadastrar(@Validated @RequestBody final Cliente objeto){
        try {
            final String retorno = service.cadastrar(objeto);
            if (retorno.equals("salvo"))
                return ResponseEntity.ok(objeto.getId());
            else
                throw new IllegalArgumentException(retorno);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
