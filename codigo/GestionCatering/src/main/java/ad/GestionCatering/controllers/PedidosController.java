package ad.GestionCatering.controllers;

import ad.GestionCatering.models.Pedidos;
import ad.GestionCatering.services.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping
    public List<Pedidos> getAllPedidos() {
        return pedidosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedidos> getPedidoById(@PathVariable Long id) {
        Optional<Pedidos> pedido = pedidosService.findById(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedidos> createPedido(@RequestBody Pedidos pedido) {
        Pedidos savedPedido = pedidosService.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedidos> updatePedido(@PathVariable Long id, @RequestBody Pedidos pedido) {
        Optional<Pedidos> existingPedido = pedidosService.findById(id);
        if (existingPedido.isPresent()) {
            pedido.setId(id);
            Pedidos updatedPedido = pedidosService.save(pedido);
            return ResponseEntity.ok(updatedPedido);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        if (pedidosService.findById(id).isPresent()) {
            pedidosService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
