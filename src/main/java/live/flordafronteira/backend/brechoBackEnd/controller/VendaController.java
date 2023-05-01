package live.flordafronteira.backend.brechoBackEnd.controller;

import live.flordafronteira.backend.brechoBackEnd.entity.Venda;
import live.flordafronteira.backend.brechoBackEnd.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
