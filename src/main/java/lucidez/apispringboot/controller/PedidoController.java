package lucidez.apispringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lucidez.apispringboot.entity.Pedido;
import lucidez.apispringboot.service.PedidoService;



@Controller
@RequestMapping(value = "/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/save")
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {
        pedido = pedidoService.save(pedido);
        
        return ResponseEntity.ok().body(pedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedido(@PathVariable Long id) {
        Pedido pedido = pedidoService.findById(id);

        return ResponseEntity.ok().body(pedido);
        
    }
    
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Pedido>> buscarTodosPedidos() {
        List<Pedido> pedidos = pedidoService.findAll();

        return ResponseEntity.ok().body(pedidos);
    }

}
