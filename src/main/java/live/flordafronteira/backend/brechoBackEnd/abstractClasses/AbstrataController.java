package live.flordafronteira.backend.brechoBackEnd.abstractClasses;

import live.flordafronteira.backend.brechoBackEnd.entity.Cliente;
import live.flordafronteira.backend.brechoBackEnd.entity.Entidade;
import live.flordafronteira.backend.brechoBackEnd.entity.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
public abstract class AbstrataController<ServiceGenerica extends AbstrataService, ObjetoGenerico extends Entidade>{
    @Autowired
    private ServiceGenerica service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdMap(@PathVariable("id") final java.lang.Long id) {
        try {
            return ResponseEntity.ok(this.service.encontrarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> listaCompleta(){
        try {
            return ResponseEntity.ok(this.service.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get_by_ativo")
    public ResponseEntity<?> getByAtivo(){
        try {
            return ResponseEntity.ok(this.service.encontrarAtivos());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@Validated @RequestBody final ObjetoGenerico objeto){
        try {
            final String retorno = service.cadastrar(objeto);
            if (retorno.equals("salvo"))
                return ResponseEntity.ok("cadastrado com sucesso");
            else
                throw new IllegalArgumentException(retorno);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@Validated @RequestBody final Cliente objeto) {
        try {
            final Long idCliente = service.cadastrarComRetorno(objeto);
            if (idCliente != null) {
                return ResponseEntity.ok(idCliente);
            } else {
                throw new IllegalArgumentException("Falha ao cadastrar o cliente.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor.");
        }
    }
    @PutMapping
    public ResponseEntity<?> editar(@Validated @RequestParam("id") final java.lang.Long id,
                                    @RequestBody final ObjetoGenerico objeto) {
        try {
            final String retorno = service.atualizar(id, objeto);
            if (retorno.equals("salvo"))
                return ResponseEntity.ok("Dados atualizados com sucesso!");
            else
                throw new IllegalArgumentException(retorno);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam("id") final Long id) {
        try {
            return ResponseEntity.ok(service.deletaDesativa(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
