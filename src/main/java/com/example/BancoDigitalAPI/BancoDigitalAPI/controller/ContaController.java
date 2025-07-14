package com.example.BancoDigitalAPI.BancoDigitalAPI.controller;

import com.example.BancoDigitalAPI.BancoDigitalAPI.model.Conta;
import com.example.BancoDigitalAPI.BancoDigitalAPI.service.ContaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    public ResponseEntity<Conta> criar(@RequestBody Conta conta) {
        Conta contaSalva = contaService.salvar(conta);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contaSalva.getId())
                .toUri();
        return ResponseEntity.created(location).body(contaSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarPorId(@PathVariable Long id) {
        Conta conta = contaService.buscarPorId(id);
        return ResponseEntity.ok(conta);
    }

    @PostMapping("/{id}/transferencia")
    public ResponseEntity<Void> transferir(
            @PathVariable Long id,
            @RequestParam Long contaDestinoId,
            @RequestParam BigDecimal valor) {
        contaService.transferir(id, contaDestinoId, valor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/saldo")
    public ResponseEntity<BigDecimal> consultarSaldo(@PathVariable Long id) {
        BigDecimal saldo = contaService.consultarSaldo(id);
        return ResponseEntity.ok(saldo);
    }

    @PostMapping("/{id}/pix")
    public ResponseEntity<Void> realizarPix(
            @PathVariable Long id,
            @RequestParam String chavePix,
            @RequestParam BigDecimal valor) {
        contaService.realizarPix(id, chavePix, valor);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/deposito")
    public ResponseEntity<Void> depositar(
            @PathVariable Long id,
            @RequestParam BigDecimal valor) {
        contaService.depositar(id, valor);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/saque")
    public ResponseEntity<Void> sacar(
            @PathVariable Long id,
            @RequestParam BigDecimal valor) {
        contaService.sacar(id, valor);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/manutencao")
    public ResponseEntity<Void> aplicarTaxaManutencao(@PathVariable Long id) {
        contaService.aplicarTaxaManutencao(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/rendimentos")
    public ResponseEntity<Void> aplicarRendimentos(@PathVariable Long id) {
        contaService.aplicarRendimentos(id);
        return ResponseEntity.ok().build();
    }
}