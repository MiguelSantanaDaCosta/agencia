package com.santana.agencia.controller.web;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.santana.agencia.controller.web.dto.CriarClienteDto;
import com.santana.agencia.model.builder.ClienteBuilder;
import com.santana.agencia.model.entity.Cliente;
import com.santana.agencia.service.ClienteService;

/**
 * ClienteWebController
 */
@Controller
@RequestMapping("/clientes")
public class ClienteWebController {
  @Autowired
  private ClienteService clienteService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("clientes", clienteService.listarTodos());
    return "Clientes";
  }

  @PostMapping
  public String cadastrarCliente(@ModelAttribute CriarClienteDto dto) {
    try {
      Cliente cliente = new ClienteBuilder()
        .comNome(dto.nome())
        .comEmail(dto.email())
        .comCpf(dto.cpf())
        .comEndereco(dto.endereco())
        .comTelefone(dto.telefone())
        .comStatus(true)
        .build();
      clienteService.salvar(cliente);

      return "redirect:/clientes";
    } catch (Exception err) {
      System.out.println(err);
      return "redirect:/clientes";
    }
  }

  @GetMapping("/deletar")
  public String deletarCliente(@RequestParam Long clienteId) {
    clienteService.deletar(clienteId);
    return "redirect:/clientes";
  }
}
