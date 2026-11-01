
package com.ejemplo.apividrios.controller;

import com.ejemplo.apividrios.entity.Vidrio;
import com.ejemplo.apividrios.service.VidrioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vidrios")
public class VidrioController {

    private final VidrioService service;

    public VidrioController(VidrioService service) {
        this.service = service;
    }

    // CREAR un vidrio
    @PostMapping
    public ResponseEntity<Vidrio> crear(@RequestBody Vidrio vidrio) {
        Vidrio nuevo = service.guardar(vidrio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // CONSULTAR todos los vidrios
    @GetMapping
    public ResponseEntity<List<Vidrio>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // CONSULTAR un vidrio por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vidrio> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // BUSCAR vidrios por tipo
    @GetMapping("/buscar")
    public ResponseEntity<List<Vidrio>> buscarPorTipo(
            @RequestParam String tipo) {
        return ResponseEntity.ok(service.buscarPorTipo(tipo));
    }

    // ACTUALIZAR un vidrio
    @PutMapping("/{id}")
    public ResponseEntity<Vidrio> actualizar(
            @PathVariable Long id,
            @RequestBody Vidrio datos) {
        try {
            return ResponseEntity.ok(service.actualizar(id, datos));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ELIMINAR un vidrio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
