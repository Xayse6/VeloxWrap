package br.com.veloxwrap.controller.service;

import br.com.veloxwrap.model.Modelo;
import br.com.veloxwrap.model.Marca;
import br.com.veloxwrap.repository.ModeloRepository;
import br.com.veloxwrap.repository.MarcaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    @Autowired
    private ModeloRepository repository;

    @Autowired
    private MarcaRepository marcaRepository;

    @PostMapping
    public ResponseEntity<String> criar(@ModelAttribute Modelo modelo) {

        try {

            Marca marca = marcaRepository.findById(modelo.getMarca().getIdMarca())
                    .orElseThrow(() -> new RuntimeException("Marca não encontrada"));

            modelo.setMarca(marca);

            repository.save(modelo);

            return ResponseEntity.ok("1");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("0");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Integer id,
                                            @ModelAttribute Modelo modelo) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Marca marca = marcaRepository.findById(modelo.getMarca().getIdMarca())
                .orElseThrow(() -> new RuntimeException("Marca não encontrada"));

        modelo.setIdModelo(id);
        modelo.setMarca(marca);

        repository.save(modelo);

        return ResponseEntity.ok("1");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.ok("1");
    }
}