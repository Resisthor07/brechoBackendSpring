package live.flordafronteira.backend.brechoBackEnd.abstractClasses;

import live.flordafronteira.backend.brechoBackEnd.entity.Entidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public abstract class AbstrataController<ServiceGenerica extends AbstrataService, ObjetoGenerico extends Entidade>{
    @Autowired
    private ServiceGenerica service;

    @GetMapping
    public ResponseEntity<?> findByIdMap(@RequestParam("id") final java.lang.Long id) {
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
                return ResponseEntity.ok("Dados cadastrados com sucesso!");
            else
                throw new IllegalArgumentException(retorno);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
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
