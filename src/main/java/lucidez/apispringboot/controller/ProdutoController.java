package lucidez.apispringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lucidez.apispringboot.entity.Produto;
import lucidez.apispringboot.exception.ProdutoNullException;
import lucidez.apispringboot.exception.ProdutoPrecoException;
import lucidez.apispringboot.service.ProdutoService;


@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    
    @Autowired
    ProdutoService produtoService;
    
    @PostMapping(value = "/save")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) throws Exception {
        produto = produtoService.save(produto);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long id) {
        Produto produto = produtoService.findById(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Produto>> buscarTodosProduto() {
        List<Produto> produtos = produtoService.findAll();
        return ResponseEntity.ok().body(produtos);
    }
}