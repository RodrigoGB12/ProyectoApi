package ad.GestionCatering.controllers;

import ad.GestionCatering.models.Personal;
import ad.GestionCatering.services.PersonalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personal")
public class PersonalController {
    @Autowired
    private PersonalService personalService;

    @GetMapping
    public List<Personal> getAllPersonal() {
        return personalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personal> getPersonalById(@PathVariable Long id) {
        Optional<Personal> personal = personalService.findById(id);
        return personal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Personal> createPersonal(@RequestBody @Valid Personal personal) {
        Personal savedPersonal = personalService.save(personal);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersonal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personal> updatePersonal(@PathVariable Long id, @RequestBody Personal personal) {
        Optional<Personal> existingPersonal = personalService.findById(id);
        if (existingPersonal.isPresent()) {
            personal.setId(id);
            Personal updatedPersonal = personalService.save(personal);
            return ResponseEntity.ok(updatedPersonal);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonal(@PathVariable Long id) {
        if (personalService.findById(id).isPresent()) {
            personalService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
