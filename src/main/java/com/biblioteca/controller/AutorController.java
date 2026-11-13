package com.biblioteca.controller;

import com.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autor")
public class AutorController {

    @GetMapping
    public String exibirAutor(Model model) {
        Autor autor = new Autor();
        autor.setNome("Machado de Assis");
        autor.setNacionalidade("Brasileira");
        autor.setObras("Dom Casmurro, Memórias Póstumas de Brás Cubas");

        model.addAttribute("autor", autor);

        return "autor";
    }
}
