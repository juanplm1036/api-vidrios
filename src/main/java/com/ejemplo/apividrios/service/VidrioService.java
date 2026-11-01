
package com.ejemplo.apividrios.service;

import com.ejemplo.apividrios.entity.Vidrio;
import com.ejemplo.apividrios.repository.VidrioRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VidrioService {

    private final VidrioRepository repository;

    public VidrioService(VidrioRepository repository) {
        this.repository = repository;
    }

    // Guardar un vidrio
    public Vidrio guardar(Vidrio vidrio) {
        return repository.save(vidrio);
    }

    // Consultar todos los vidrios
    public List<Vidrio> listar() {
        return repository.findAll();
    }

    // Buscar un vidrio por ID
    public Optional<Vidrio> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Buscar vidrios por tipo
    public List<Vidrio> buscarPorTipo(String tipo) {
        return repository.findByTipoIgnoreCase(tipo);
    }

    // Actualizar un vidrio
    public Vidrio actualizar(Long id, Vidrio datos) {
        Vidrio vidrio = repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Vidrio no encontrado"));

        vidrio.setReferencia(datos.getReferencia());
        vidrio.setTipo(datos.getTipo());
        vidrio.setEspesor(datos.getEspesor());
        vidrio.setPrecio(datos.getPrecio());
        vidrio.setStock(datos.getStock());

        return repository.save(vidrio);
    }

    // Eliminar un vidrio
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
