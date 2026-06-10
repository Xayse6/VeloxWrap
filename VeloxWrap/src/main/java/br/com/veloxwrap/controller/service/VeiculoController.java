package br.com.veloxwrap.controller.service;

import br.com.veloxwrap.model.Modelo;
import br.com.veloxwrap.model.Usuario;
import br.com.veloxwrap.model.Veiculo;
import br.com.veloxwrap.repository.ModeloRepository;
import br.com.veloxwrap.repository.UsuarioRepository;
import br.com.veloxwrap.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    @PostMapping("/veiculo/cadastrar")
    public ResponseEntity<String> salvar(
            @RequestParam(required = false) Integer idVeiculo,
            @RequestParam Integer idUsuario,
            @RequestParam Integer idModelo,
            @RequestParam String placa,
            @RequestParam String cor,
            @RequestParam(required = false) String apelido
    ) {

        Veiculo veiculo;

        if (idVeiculo != null) {
            veiculo = repository.findById(idVeiculo)
                    .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        } else {
            veiculo = new Veiculo();
        }

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Modelo modelo = modeloRepository.findById(idModelo)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado"));

        veiculo.setUsuario(usuario);
        veiculo.setModelo(modelo);
        veiculo.setPlaca(placa);
        veiculo.setCor(cor);
        veiculo.setApelido(apelido);

        repository.save(veiculo);

        return ResponseEntity.ok("1");
    }

    @DeleteMapping("/veiculos/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.ok("1");
    }
}