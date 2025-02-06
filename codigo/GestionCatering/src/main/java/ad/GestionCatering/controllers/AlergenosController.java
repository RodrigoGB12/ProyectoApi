package ad.GestionCatering.controllers;

import ad.GestionCatering.models.Alergenos;
import ad.GestionCatering.services.AlergenosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alergenos")
public class AlergenosController {

    @Autowired
    private AlergenosService alergenosService;

    @GetMapping
    public List<Alergenos> obtenerTodas() {
        return alergenosService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alergenos> getAlergenoById(@PathVariable Long id) {
        Optional<Alergenos> alergeno = alergenosService.findById(id);
        return alergeno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alergenos> createAlergeno(@RequestBody Alergenos alergeno) {
        Alergenos savedAlergeno = alergenosService.save(alergeno);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAlergeno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alergenos> updateAlergeno(@PathVariable Long id, @RequestBody Alergenos alergeno) {
        Optional<Alergenos> existingAlergeno = alergenosService.findById(id);
        if (existingAlergeno.isPresent()) {
            alergeno.setId(id);
            Alergenos updatedAlergeno = alergenosService.save(alergeno);
            return ResponseEntity.ok(updatedAlergeno);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlergeno(@PathVariable Long id) {
        if (alergenosService.findById(id).isPresent()) {
            alergenosService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
