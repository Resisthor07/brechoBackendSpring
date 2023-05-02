package live.flordafronteira.backend.brechoBackEnd.controller;

import live.flordafronteira.backend.brechoBackEnd.entity.Administrador;
import live.flordafronteira.backend.brechoBackEnd.entity.Produto;
import live.flordafronteira.backend.brechoBackEnd.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


}
