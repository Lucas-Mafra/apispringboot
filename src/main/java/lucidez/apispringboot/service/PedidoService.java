package lucidez.apispringboot.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucidez.apispringboot.entity.Pedido;
import lucidez.apispringboot.entity.Produto;
import lucidez.apispringboot.repository.PedidoRepository;
import lucidez.apispringboot.repository.ProdutoRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido save(Pedido pedido){
        Set<Produto> produtos = new HashSet<>();

        pedido.setDataPedido(LocalDateTime.now());
        pedido.getProdutos().forEach(produto -> { produtos.add(produtoRepository.getReferenceById(produto.getId())); });
        pedido.setProdutos(produtos);
        
        return pedidoRepository.save(pedido);
    }

    public Pedido findById(Long id){
        return pedidoRepository.findById(id).orElse(null);
    }

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }
}
