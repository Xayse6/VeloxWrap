package br.com.veloxwrap.controller.novoCadastro;

import br.com.veloxwrap.model.Marca;
import br.com.veloxwrap.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NovaMarca {

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping("/NovaMarca")
    public String novaMarca(Model model) {
        model.addAttribute("marca", new Marca());
        return "pages/marca/marcaCadastrar";
    }

    @GetMapping("/marca/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {

        Marca marca = marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada"));

        model.addAttribute("marca", marca);

        return "pages/marca/marcaCadastrar";
    }
}