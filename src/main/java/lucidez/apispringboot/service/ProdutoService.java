package lucidez.apispringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lucidez.apispringboot.entity.Produto; // Entidade
import lucidez.apispringboot.repository.ProdutoRepository; // SQL

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;

    public Produto save (Produto produto){
        return repository.save(produto);
    }

    public Produto findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }
}
