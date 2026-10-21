
package com.ejemplo.apividrios.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;
import com.ejemplo.apividrios.dto.VidrioRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;


@RestController
@RequestMapping("/api/vidrios")
public class VidrioController {

    @GetMapping
    public List<String> listarVidrios() {
        return List.of(
            "Vidrio incoloro 5 mm",
            "Vidrio incoloro 6 mm",
            "Espejo ECO 3 mm"
        );
    }

    @GetMapping("/{id}")
    public String buscarVidrio(@PathVariable int id) {
        List<String> vidrios = List.of(
            "Vidrio incoloro 5 mm",
            "Vidrio incoloro 6 mm",
            "Espejo ECO 3 mm"
        );

        if (id < 1 || id > vidrios.size()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Vidrio no encontrado"
            );
        }

        return vidrios.get(id - 1);
    }
@GetMapping("/buscar")
public List<String> filtrarVidrios(@RequestParam String tipo) {

        List<String> vidrios = List.of(
            "Vidrio incoloro 5 mm",
            "Vidrio incoloro 6 mm",
            "Espejo ECO 3 mm"
        );

        return vidrios.stream()
            .filter(vidrio -> {
                if (tipo.equalsIgnoreCase("INCOLORO")) {
                    return vidrio.toLowerCase().contains("incoloro");
                }
                if (tipo.equalsIgnoreCase("ESPEJO")) {
                    return vidrio.toLowerCase().contains("espejo");
                }
                return false;
            })
            .toList();
    }
    
    private final List<VidrioRequest> inventario = new ArrayList<>();

    @PostMapping
    public ResponseEntity<VidrioRequest> registrarVidrio(
            @RequestBody VidrioRequest nuevoVidrio) {

        inventario.add(nuevoVidrio);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoVidrio);
    }


}
