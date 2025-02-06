package ad.GestionCatering.controllers;

import ad.GestionCatering.models.Clientes;
import ad.GestionCatering.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private ClientesService clientesService;

    @GetMapping
    public List<Clientes> getAllClientes() {
        return clientesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> getClienteById(@PathVariable Long id) {
        Optional<Clientes> cliente = clientesService.findById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Clientes> createCliente(@RequestBody Clientes cliente) {
        Clientes savedCliente = clientesService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> updateCliente(@PathVariable Long id, @RequestBody Clientes cliente) {
        Optional<Clientes> existingCliente = clientesService.findById(id);
        if (existingCliente.isPresent()) {
            cliente.setId(id);
            Clientes updatedCliente = clientesService.save(cliente);
            return ResponseEntity.ok(updatedCliente);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        if (clientesService.findById(id).isPresent()) {
            clientesService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
