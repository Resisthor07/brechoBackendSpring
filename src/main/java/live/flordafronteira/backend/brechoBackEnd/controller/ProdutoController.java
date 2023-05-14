package live.flordafronteira.backend.brechoBackEnd.controller;

import live.flordafronteira.backend.brechoBackEnd.abstractClasses.AbstrataController;
import live.flordafronteira.backend.brechoBackEnd.entity.Produto;
import live.flordafronteira.backend.brechoBackEnd.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController extends AbstrataController<ProdutoService, Produto> {

}
