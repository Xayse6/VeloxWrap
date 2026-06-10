package br.com.veloxwrap.controller.service;

import br.com.veloxwrap.model.Usuario;
import br.com.veloxwrap.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/UsuarioCadastrar")
    public ResponseEntity<String> criar(Usuario usuario) {

        repository.save(usuario);
        return ResponseEntity.ok("1");
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Integer id,
                                            Usuario usuario) {

        Optional<Usuario> existente = repository.findById(id);

        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Usuario u = existente.get();

        u.setNome(usuario.getNome());
        u.setEmail(usuario.getEmail());
        u.setCpf(usuario.getCpf());
        u.setDataNascimento(usuario.getDataNascimento());

        if (usuario.getSenha() != null && !usuario.getSenha().isBlank()) {
            u.setSenha(usuario.getSenha());
        }

        repository.save(u);

        return ResponseEntity.ok("1");
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.ok("1");
    }

}