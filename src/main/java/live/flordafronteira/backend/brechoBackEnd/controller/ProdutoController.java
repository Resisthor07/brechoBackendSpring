package live.flordafronteira.backend.brechoBackEnd.controller;
import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataController;
import live.flordafronteira.backend.brechoBackEnd.entity.Produto;
import live.flordafronteira.backend.brechoBackEnd.repository.ProdutoRepositorio;
import live.flordafronteira.backend.brechoBackEnd.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController extends AbstrataController<ProdutoService, Produto> {

@Autowired
private ProdutoRepositorio produtoRepositorio;

    @GetMapping("/")
    public ResponseEntity<?> listaCompleta(@RequestParam("tipo") final String tipo){
        try {
            return ResponseEntity.ok(this.produtoRepositorio.listaProdutosPorTipo(tipo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
