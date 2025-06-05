package com.santana.agencia.controller.api;

import com.santana.agencia.model.entity.ModalFornecedor;
import com.santana.agencia.service.ModalFornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.santana.agencia.exception.ResourceNotFoundException;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/modal-fornecedores")
public class ModalFornecedorController {

    @Autowired
    private final ModalFornecedorService service;

    public ModalFornecedorController(ModalFornecedorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ModalFornecedor>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/fornecedor/{fornecedorId}")
    public ResponseEntity<List<ModalFornecedor>> listarPorFornecedor(@PathVariable Long fornecedorId) {
        return ResponseEntity.ok(service.listarPorFornecedorId(fornecedorId));
    }

    @GetMapping("/modal/{modalId}")
    public ResponseEntity<List<ModalFornecedor>> listarPorModal(@PathVariable Long modalId) {
        return ResponseEntity.ok(service.listarPorModalId(modalId));
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<ModalFornecedor>> listarModaisDisponiveis() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModalFornecedor> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id).orElseThrow(
            () -> new ResourceNotFoundException("ModalFornecedor não encontrado com id: " + id)
        ));
    }

    @PostMapping
    public ResponseEntity<ModalFornecedor> salvar(@RequestBody ModalFornecedor modalFornecedor) {
        ModalFornecedor salvo = service.salvar(modalFornecedor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(salvo.getId())
                .toUri();
        return ResponseEntity.created(location).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModalFornecedor> atualizar(@PathVariable Long id, @RequestBody ModalFornecedor modalFornecedor) {
        return ResponseEntity.ok(service.atualizar(id, modalFornecedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/preco/{precoMin}/{precoMax}")
    public ResponseEntity<List<ModalFornecedor>> buscarPorFaixaDePreco(
            @PathVariable Double precoMin,
            @PathVariable Double precoMax) {
        return ResponseEntity.ok(service.buscarPorFaixaDePreco(precoMin, precoMax));
    }
}
