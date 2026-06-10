package br.com.veloxwrap.controller.service;

import br.com.veloxwrap.model.Marca;
import br.com.veloxwrap.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarcaController {

    @Autowired
    private MarcaRepository repository;

    @PostMapping("/MarcaCadastrar")
    public ResponseEntity<String> criar(@RequestBody Marca marca) {

        repository.save(marca);
        return ResponseEntity.ok("1");
    }

    @PutMapping("/marcas/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Integer id,
                                            @RequestBody Marca marca) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        marca.setIdMarca(id);
        repository.save(marca);

        return ResponseEntity.ok("1");
    }

    @DeleteMapping("/marcas/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.ok("1");
    }
}
