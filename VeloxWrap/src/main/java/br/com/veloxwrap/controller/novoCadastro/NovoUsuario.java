package br.com.veloxwrap.controller.novoCadastro;

import br.com.veloxwrap.model.Usuario;
import br.com.veloxwrap.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NovoUsuario {

    private final UsuarioRepository usuarioRepository;

    public NovoUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/NovoUsuario")
    public String novoUsuario(Model model) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("editando", false);

        return "pages/usuario/usuarioCadastrar";
    }

    @GetMapping("/usuario/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        model.addAttribute("usuario", usuario);
        model.addAttribute("editando", true);

        return "pages/usuario/usuarioCadastrar";
    }
}