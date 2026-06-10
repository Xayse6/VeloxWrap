package br.com.veloxwrap.controller.listar;

import br.com.veloxwrap.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class ListarUsuarios {

    private final UsuarioRepository repository;

    public ListarUsuarios(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listarUsuarios(Model model) {

        model.addAttribute("usuarios", repository.findAll());

        return "pages/Usuario/usuarioListar";
    }
}