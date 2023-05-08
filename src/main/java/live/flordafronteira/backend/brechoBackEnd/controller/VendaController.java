package live.flordafronteira.backend.brechoBackEnd.controller;

import live.flordafronteira.backend.brechoBackEnd.entity.Venda;
import live.flordafronteira.backend.brechoBackEnd.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "api/venda")
public class VendaController {
    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping
    private ResponseEntity<?> getId(@RequestParam("id") final Long id) {
        final Venda vendaBanco = vendaRepository.findById(id).orElse(null);
        return ResponseEntity.ok(vendaBanco);
    }

    @PostMapping
    private ResponseEntity<?> postVenda(@RequestBody final Venda obj){
        try {

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError().body("Erro no servidor: " + e);
        }
        return ResponseEntity.ok(obj);
    }


}
