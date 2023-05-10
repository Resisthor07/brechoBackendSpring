package live.flordafronteira.backend.brechoBackEnd.controller;

import live.flordafronteira.backend.brechoBackEnd.entity.Produto;
import live.flordafronteira.backend.brechoBackEnd.repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepositorio produtoRepository;

    @GetMapping
    public ResponseEntity<?> findByRequest(@RequestParam("id")final Long id){
        final Produto produto = this.produtoRepository.findById(id).orElse(null);
        return produto == null
                ? ResponseEntity.badRequest().body("Nenhum produto encontrado!")
                : ResponseEntity.ok(produto);
    }

    @GetMapping("/lista-produtos")
    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Produto produto){
        try {
            this.produtoRepository.save(produto);
            return ResponseEntity.ok("Produto cadastrado com sucesso!");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: ");
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(
            @RequestParam("id") final Long id,
            @RequestBody final Produto produto){

        final Produto produtoBanco = this.produtoRepository.findById(id).orElse(null);
        if (produtoBanco == null || produto.getId().equals(produto.getId())){
            throw new RuntimeException("Não foi possivel identificar o produto informado.");

        }

        try {
            this.produtoRepository.save(produto);
            return ResponseEntity.ok("Produto atualizado com sucesso!");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: "+ e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error: "+ e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(
            @RequestParam("id") final Long id
    ){
        final Produto produtoBanco = this.produtoRepository.findById(id).orElse(null);

        this.produtoRepository.delete(produtoBanco);
        return ResponseEntity.ok("Produto excluido com Sucesso");
    }
}
