package com.santana.agencia.controller.web;

import com.santana.agencia.model.entity.Viagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.santana.agencia.service.ViagemService;


/**
 * AgenciaWebController
 */
@Controller
@RequestMapping("/")
public class AgenciaWebController {
    @Autowired
    private ViagemService viagemService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("viagens", viagemService.listarTodos());
        model.addAttribute("viagem", new Viagem());
        return "Agencia";
    }

    @PostMapping("/viagens/cadastrar")
    public String cadastrarViagem(Viagem viagem) {
        viagemService.salvar(viagem);
        return "redirect:/";
    }

    @GetMapping("/viagens/deletar")
    public String deletarViagem(@RequestParam Long viagemId) {
      viagemService.deletar(viagemId);
      return "redirect:/";
    }
}
