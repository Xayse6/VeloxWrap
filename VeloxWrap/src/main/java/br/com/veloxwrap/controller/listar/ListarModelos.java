package br.com.veloxwrap.controller.listar;

import br.com.veloxwrap.repository.ModeloRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modelos")
public class ListarModelos {

    private final ModeloRepository repository;

    public ListarModelos(ModeloRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listarModelos(Model model) {

        model.addAttribute("modelos", repository.findAll());

        return "pages/Modelo/modeloListar";
    }
}