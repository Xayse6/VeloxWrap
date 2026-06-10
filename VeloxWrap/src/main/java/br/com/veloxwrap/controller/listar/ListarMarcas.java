package br.com.veloxwrap.controller.listar;

import br.com.veloxwrap.repository.MarcaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/marcas")
public class ListarMarcas {

    private final MarcaRepository repository;

    public ListarMarcas(MarcaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listarMarcas(Model model) {

        model.addAttribute("marcas", repository.findAll());

        return "pages/Marca/marcaListar";
    }
}
