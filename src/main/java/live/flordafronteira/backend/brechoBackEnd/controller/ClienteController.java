package live.flordafronteira.backend.brechoBackEnd.controller;
import live.flordafronteira.backend.brechoBackEnd.entity.Cliente;
import live.flordafronteira.backend.brechoBackEnd.repository.ClienteRepositorio;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/api/cliente")
public class ClienteController {

    private ClienteRepositorio clienteRepositorio;

   @GetMapping
    public ResponseEntity <?> buscaID(@RequestParam("id") final Long id) {
       final Cliente valorBanco = this.clienteRepositorio.findById(id).orElse(null);
       return valorBanco == null ? ResponseEntity.badRequest().body("Nenhum Cliente corresponde ao ID informado") :
               ResponseEntity.ok(valorBanco);
   }
   @GetMapping("/clientesativos")
    public ResponseEntity<?> buscaListaClienteAtivo(){
       List <Cliente> clientes = this.clienteRepositorio.findAll();
       List <Cliente> checaCliente = new ArrayList<>();

       for (Cliente valor:clientes
            ) {
           if(valor.isStatus())
               checaCliente.add(valor);
       }
return ResponseEntity.ok(checaCliente);
   }
   @GetMapping("/listaclientes")
    ResponseEntity<?> buscaListaClientes(){

       return ResponseEntity.ok(this.clienteRepositorio.findAll());
   }

   @PostMapping
    public ResponseEntity<?> cadastraCliente(@PathVariable final Cliente cliente){
        this.clienteRepositorio.save(cliente);
       return ResponseEntity.ok("Cliente Cadastrado com Sucesso.");
   }

   @PutMapping("/{id}")
    public ResponseEntity <?> atualizaClienteCompleto(
            @PathVariable final Long id,
            @RequestBody final Cliente cliente){
        try {
            final Cliente valorBanco = this.clienteRepositorio.findById(id).orElse(null);
            if (valorBanco == null || !valorBanco.getId().equals(cliente.getId())) {
                throw new RuntimeException("Cliente não encontrado.");
            }
            this.clienteRepositorio.save(cliente);
            return ResponseEntity.ok("Cliente Atualizado.");
        }
        catch (DataIntegrityViolationException e){
          return   ResponseEntity.internalServerError().body("Erro" + e.getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Erro");
        }
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> DeletarCliente(@PathVariable final Long id){
       final Cliente cliente = this.clienteRepositorio.findById(id).orElse(null);
       return ResponseEntity.ok(cliente);
   }

}
