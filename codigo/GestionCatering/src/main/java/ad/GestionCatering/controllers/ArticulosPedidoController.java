package ad.GestionCatering.controllers;

import ad.GestionCatering.models.ArticulosPedido;
import ad.GestionCatering.services.ArticulosPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articulos-pedido")
public class ArticulosPedidoController {

    @Autowired
    private ArticulosPedidoService articulosPedidoService;

    @GetMapping
    public List<ArticulosPedido> getAllArticulosPedido() {
        return articulosPedidoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticulosPedido> getArticuloPedidoById(@PathVariable Long id) {
        Optional<ArticulosPedido> articuloPedido = articulosPedidoService.findById(id);
        return articuloPedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ArticulosPedido> createArticuloPedido(@RequestBody ArticulosPedido articuloPedido) {
        ArticulosPedido savedArticuloPedido = articulosPedidoService.save(articuloPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticuloPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticulosPedido> updateArticuloPedido(@PathVariable Long id, @RequestBody ArticulosPedido articuloPedido) {
        Optional<ArticulosPedido> existingArticuloPedido = articulosPedidoService.findById(id);
        if (existingArticuloPedido.isPresent()) {
            articuloPedido.setId(id);
            ArticulosPedido updatedArticuloPedido = articulosPedidoService.save(articuloPedido);
            return ResponseEntity.ok(updatedArticuloPedido);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticuloPedido(@PathVariable Long id) {
        if (articulosPedidoService.findById(id).isPresent()) {
            articulosPedidoService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
