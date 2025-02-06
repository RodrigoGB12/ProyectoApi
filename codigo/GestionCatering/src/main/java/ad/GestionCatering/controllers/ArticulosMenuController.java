package ad.GestionCatering.controllers;

import ad.GestionCatering.models.ArticulosMenu;
import ad.GestionCatering.services.ArticulosMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class ArticulosMenuController {

    @Autowired
    private ArticulosMenuService articulosMenuService;

    @GetMapping
    public List<ArticulosMenu> getAllArticulosMenu() {
        return articulosMenuService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticulosMenu> getArticuloMenuById(@PathVariable Long id) {
        Optional<ArticulosMenu> articuloMenu = articulosMenuService.findById(id);
        return articuloMenu.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ArticulosMenu> createArticuloMenu(@RequestBody ArticulosMenu articuloMenu) {
        ArticulosMenu savedArticuloMenu = articulosMenuService.save(articuloMenu);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticuloMenu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticulosMenu> updateArticuloMenu(@PathVariable Long id, @RequestBody ArticulosMenu articuloMenu) {
        Optional<ArticulosMenu> existingArticuloMenu = articulosMenuService.findById(id);
        if (existingArticuloMenu.isPresent()) {
            articuloMenu.setId(id);
            ArticulosMenu updatedArticuloMenu = articulosMenuService.save(articuloMenu);
            return ResponseEntity.ok(updatedArticuloMenu);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticuloMenu(@PathVariable Long id) {
        if (articulosMenuService.findById(id).isPresent()) {
            articulosMenuService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
