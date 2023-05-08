package live.flordafronteira.backend.brechoBackEnd.controller;

import live.flordafronteira.backend.brechoBackEnd.entity.Administrador;
import live.flordafronteira.backend.brechoBackEnd.entity.Produto;
import live.flordafronteira.backend.brechoBackEnd.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping (value = "api/administrador")
public class AdministradorController {
    @Autowired
    private AdministradorRepository administradorRepository;


    @GetMapping({"/lista"})
    public ResponseEntity<?> Listacompleta(){

        return ResponseEntity.ok(this.administradorRepository.findAll());
    }

    @GetMapping
    public ResponseEntity<?> findByRequest(@RequestParam("id")final Long id){
        final Administrador administrador = this.administradorRepository.findById(id).orElse(null);
        return administrador == null
                ? ResponseEntity.badRequest().body("Nenhum Usuario encontrado!")
                : ResponseEntity.ok(administrador);
    }

    @PutMapping
    public ResponseEntity<?> editar(
            @RequestParam("id") final Long id,
            @RequestBody final Administrador administrador){

        final Administrador administradorBanco = this.administradorRepository.findById(id).orElse(null);
        if (administradorBanco == null || administrador.getId().equals(administrador.getId())){
            throw new RuntimeException("Não foi possivel identificar o produto informado.");

        }

        try {
            this.administradorRepository.save(administrador);
            return ResponseEntity.ok("Produto atualizado com sucesso!");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: "+ e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error: "+ e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<?> cadastrar (@RequestBody final Administrador administrador){
        try{
            this.administradorRepository.save(administrador);
            return ResponseEntity.ok("Administrador cadastrado com sucesso!");

        }catch (Exception e){
            return ResponseEntity.badRequest().body("ERRO " + e.getMessage());
        }
    }


}
