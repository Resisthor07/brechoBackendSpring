package live.flordafronteira.backend.brechoBackEnd.controller;

import live.flordafronteira.backend.brechoBackEnd.entity.Tipo;
import live.flordafronteira.backend.brechoBackEnd.repository.TipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "api/tipo")
public class TipoController {

    @Autowired
    private TipoRepositorio tipoRepositorio;

    @GetMapping
    private ResponseEntity<?> Id(@RequestParam("id") final Long id)
    {
        final Tipo tipo = this.tipoRepositorio.findById(id).orElse(null);
        return ResponseEntity.ok(tipo);
    }
}
