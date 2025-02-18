package lucidez.apispringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucidez.apispringboot.entity.Produto;
import lucidez.apispringboot.exception.ProdutoNullException;
import lucidez.apispringboot.exception.ProdutoPrecoException;
import lucidez.apispringboot.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;

    public Produto save (Produto produto) throws Exception {
        if (produto.getNome() == null || produto.getPreco() == null)
            throw new ProdutoNullException();
        if (produto.getPreco() < 0)
            throw new ProdutoPrecoException();
            
        return repository.save(produto);
    }

    public Produto findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }
}
