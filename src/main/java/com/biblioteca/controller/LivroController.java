package com.biblioteca.controller;

import org.springframework.ui.Model;
import com.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    public List<Livro> livros = new ArrayList<>();

    @GetMapping("/inicio")
    public String inicio(){ return "livros/inicio"; }

    @GetMapping
    public String exibirLivro(Model model) {
        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-00-00000-0");

        model.addAttribute(
                "livro",livro);

        return "livros";
    }

}

