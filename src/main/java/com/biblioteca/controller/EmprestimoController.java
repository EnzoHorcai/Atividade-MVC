package com.biblioteca.controller;

import com.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @GetMapping
    public String exibirEmprestimo(Model model) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setRetirada("10/11/2026");
        emprestimo.setDevolucao("24/11/2026");

        model.addAttribute("emprestimo", emprestimo);

        return "emprestimos";
    }
}
