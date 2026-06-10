package br.com.veloxwrap.controller.listar;

import br.com.veloxwrap.repository.VeiculoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/veiculos")
public class ListarVeiculos {

    private final VeiculoRepository repository;

    public ListarVeiculos(VeiculoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listarVeiculos(Model model) {

        model.addAttribute("veiculos", repository.findAll());

        return "pages/veiculo/veiculoListar";
    }
}