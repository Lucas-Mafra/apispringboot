package lucidez.apispringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lucidez.apispringboot.entity.Produto;
import lucidez.apispringboot.service.ProdutoService;


@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    
    @Autowired
    ProdutoService produtoService;

    @PostMapping(value = "/save")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        return ResponseEntity.ok().body(produtoService.save(produto));
    }
}
