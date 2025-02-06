package ad.GestionCatering.controllers;

import ad.GestionCatering.models.ArticulosMenuAlergenos;
import ad.GestionCatering.services.ArticulosMenuAlergenosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articulos-menu-alergenos")
public class ArticulosMenuAlergenosController {

    @Autowired
    private ArticulosMenuAlergenosService articulosMenuAlergenosService;

    @GetMapping
    public List<ArticulosMenuAlergenos> getAllArticulosMenuAlergenos() {
        return articulosMenuAlergenosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticulosMenuAlergenos> getArticuloMenuAlergenosById(@PathVariable Long id) {
        Optional<ArticulosMenuAlergenos> articuloMenuAlergenos = articulosMenuAlergenosService.findById(id);
        return articuloMenuAlergenos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ArticulosMenuAlergenos> createArticuloMenuAlergenos(@RequestBody ArticulosMenuAlergenos articuloMenuAlergenos) {
        ArticulosMenuAlergenos savedArticuloMenuAlergenos = articulosMenuAlergenosService.save(articuloMenuAlergenos);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticuloMenuAlergenos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticulosMenuAlergenos> updateArticuloMenuAlergenos(@PathVariable Long id, @RequestBody ArticulosMenuAlergenos articuloMenuAlergenos) {
        Optional<ArticulosMenuAlergenos> existingArticuloMenuAlergenos = articulosMenuAlergenosService.findById(id);
        if (existingArticuloMenuAlergenos.isPresent()) {
            articuloMenuAlergenos.setId(id);
            ArticulosMenuAlergenos updatedArticuloMenuAlergenos = articulosMenuAlergenosService.save(articuloMenuAlergenos);
            return ResponseEntity.ok(updatedArticuloMenuAlergenos);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticuloMenuAlergenos(@PathVariable Long id) {
        if (articulosMenuAlergenosService.findById(id).isPresent()) {
            articulosMenuAlergenosService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
