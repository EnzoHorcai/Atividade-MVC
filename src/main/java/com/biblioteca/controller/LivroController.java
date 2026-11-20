package com.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.model.Livro;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final List<Livro> livros = new ArrayList<>();
    private Long proximoId = 1L;

    public LivroController() {
        livros.add(new Livro(
                proximoId++,
                "Dom Casmurro",
                "Machado de Assis",
                "978-85-00-00000-0"
        ));
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", livros);
        return "livros";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("livro", new Livro());
        model.addAttribute("tituloPagina", "Novo livro");
        return "livro-form";
    }

    @PostMapping
    public String salvar(Livro livro) {
        livro.setId(proximoId++);
        livros.add(livro);
        return "redirect:/livros";
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        Livro livro = buscarPorId(id);

        if (livro == null) {
            return "redirect:/livros";
        }

        model.addAttribute("livro", livro);
        model.addAttribute("tituloPagina", "Editar livro");
        return "livro-form";
    }

    @PostMapping("/{id}")
    public String atualizar(@PathVariable Long id, Livro livroAtualizado) {
        Livro livro = buscarPorId(id);

        if (livro != null) {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setIsbn(livroAtualizado.getIsbn());
        }

        return "redirect:/livros";
    }

    @PostMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        livros.removeIf(livro -> livro.getId().equals(id));
        return "redirect:/livros";
    }

    private Livro buscarPorId(Long id) {
        return livros.stream()
                .filter(livro -> livro.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}