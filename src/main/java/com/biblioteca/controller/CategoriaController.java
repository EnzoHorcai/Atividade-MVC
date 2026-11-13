package com.biblioteca.controller;

import com.biblioteca.model.Categoria;
import com.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @GetMapping
    public String exibirCategoria(Model model) {
        Livro romance = new Livro();
        romance.setTitulo("Dom Casmurro");
        romance.setAutor("Machado de Assis");
        romance.setIsbn("978-85-00-00000-0");

        Livro tecnico = new Livro();
        tecnico.setTitulo("Código Limpo");
        tecnico.setAutor("Robert C. Martin");
        tecnico.setIsbn("978-85-7608-267-5");

        ArrayList<Livro> livrosGenero = new ArrayList<>();
        livrosGenero.add(romance);

        ArrayList<Livro> livrosArea = new ArrayList<>();
        livrosArea.add(tecnico);

        Categoria categoria = new Categoria();
        categoria.setLivrosGenero(livrosGenero);
        categoria.setLivrosArea(livrosArea);

        model.addAttribute("categoria", categoria);

        return "categorias";
    }
}
