package br.com.veloxwrap.controller.novoCadastro;

import br.com.veloxwrap.model.Modelo;
import br.com.veloxwrap.repository.MarcaRepository;
import br.com.veloxwrap.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NovoModelo {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    @GetMapping("/NovoModelo")
    public String novoModelo(Model model) {

        model.addAttribute("modelo", new Modelo());
        model.addAttribute("marcas", marcaRepository.findAll());

        return "pages/Modelo/modeloCadastrar";
    }


    @GetMapping("modelo/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {

        Modelo modelo = modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado"));

        model.addAttribute("modelo", modelo);
        model.addAttribute("marcas", marcaRepository.findAll());

        return "pages/Modelo/modeloCadastrar";
    }
}