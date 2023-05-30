package live.flordafronteira.backend.brechoBackEnd.controller;
import live.flordafronteira.backend.brechoBackEnd.entity.Cliente;
import live.flordafronteira.backend.brechoBackEnd.repository.ClienteRepositorio;


import live.flordafronteira.backend.brechoBackEnd.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/api/cliente")
public class ClienteController {
@Autowired
    private ClienteService clienteService;
@Autowired
private ClienteRepositorio clienteRepositorio;

   @GetMapping
    public ResponseEntity <?> buscaID(@RequestParam("id") final Long id) {
       final Cliente valorBanco = this.clienteRepositorio.findById(id).orElse(null);
       return valorBanco == null ? ResponseEntity.badRequest().body("Nenhum Cliente corresponde ao ID informado") :
               ResponseEntity.ok(valorBanco);
   }

   @GetMapping("/clientesativos")
    public ResponseEntity<?>buscaListaClientesAtivos(){
    return ResponseEntity.ok(this.clienteRepositorio.listaClienteAtivo());
   }


   @GetMapping("/listaclientes")
    public ResponseEntity<?> buscaListaClientes(){
       return ResponseEntity.ok(this.clienteRepositorio.findAll());
   }

   @PostMapping
    public ResponseEntity<?> cadastraCliente(@RequestBody final Cliente cliente){
        try{
            clienteService.cadastraCliente(cliente);
           return ResponseEntity.ok("Cliente cadastrado com sucesso");
        }
        catch (RuntimeException e){
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        }
   }

   @PutMapping("/{id}")
    public ResponseEntity <?> atualizaClienteCompleto(
            @PathVariable final Long id,
            @RequestBody final Cliente cliente){
        try {
            clienteService.atualizarCliente(id, cliente);
            return ResponseEntity.ok("Cliente Atualizado.");
        }

        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Erro: " + e.getMessage());
        }
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> DeletarCliente(@RequestParam("id") final Long id) {
       try {
           clienteService.deletarCliente(id);
           return ResponseEntity.ok("Cliente deletado.");
       } catch (RuntimeException e) {
           return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
       }
   }
}
