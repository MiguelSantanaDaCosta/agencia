package com.santana.agencia.controller.api;


import com.santana.agencia.model.entity.Compra;
import com.santana.agencia.service.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<Compra> registrarCompra(@RequestBody Compra compra) {
        Compra compraRegistrada = compraService.registrarCompra(compra);
        return ResponseEntity.ok(compraRegistrada);
    }
}
