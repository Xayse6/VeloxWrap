package br.com.veloxwrap.controller.novoCadastro;

import br.com.veloxwrap.model.Veiculo;
import br.com.veloxwrap.repository.ModeloRepository;
import br.com.veloxwrap.repository.UsuarioRepository;

import br.com.veloxwrap.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NovoVeiculo {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    @GetMapping("/NovoVeiculo")
    public String novo(Model model) {

        model.addAttribute("veiculo", new Veiculo());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("modelos", modeloRepository.findAll());

        return "pages/veiculo/veiculoCadastrar";
    }

    @GetMapping("/veiculo/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {

        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        model.addAttribute("veiculo", veiculo);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("modelos", modeloRepository.findAll());

        return "pages/veiculo/veiculoCadastrar";
    }
}
