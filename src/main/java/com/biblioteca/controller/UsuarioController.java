package com.biblioteca.controller;

import com.biblioteca.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping
    public String exibirUsuario(Model model) {
        Usuario usuario = new Usuario();
        usuario.setLogin("maria.silva");
        usuario.setCategoriaFavorita("Romance");

        model.addAttribute("usuario", usuario);

        return "usuarios";
    }
}
