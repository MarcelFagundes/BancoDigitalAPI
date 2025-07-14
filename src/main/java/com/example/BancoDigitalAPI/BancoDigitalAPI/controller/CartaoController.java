package com.example.BancoDigitalAPI.BancoDigitalAPI.controller;

import com.example.BancoDigitalAPI.BancoDigitalAPI.model.Cartao;
import com.example.BancoDigitalAPI.BancoDigitalAPI.service.CartaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    private final CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @PostMapping
    public ResponseEntity<Cartao> emitir(@RequestBody Cartao cartao) {
        Cartao cartaoSalvo = cartaoService.salvar(cartao);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cartaoSalvo.getId())
                .toUri();
        return ResponseEntity.created(location).body(cartaoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartao> buscarPorId(@PathVariable Long id) {
        Cartao cartao = cartaoService.buscarPorId(id);
        return ResponseEntity.ok(cartao);
    }

    @PostMapping("/{id}/pagamento")
    public ResponseEntity<Void> realizarPagamento(
            @PathVariable Long id,
            @RequestParam BigDecimal valor,
            @RequestParam String senha) {
        cartaoService.realizarPagamento(id, valor, senha);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/limite")
    public ResponseEntity<Void> alterarLimite(
            @PathVariable Long id,
            @RequestParam BigDecimal novoLimite) {
        cartaoService.alterarLimite(id, novoLimite);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> alterarStatus(
            @PathVariable Long id,
            @RequestParam boolean ativo) {
        cartaoService.alterarStatus(id, ativo);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/senha")
    public ResponseEntity<Void> alterarSenha(
            @PathVariable Long id,
            @RequestParam String novaSenha) {
        cartaoService.alterarSenha(id, novaSenha);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/fatura")
    public ResponseEntity<BigDecimal> consultarFatura(@PathVariable Long id) {
        BigDecimal fatura = cartaoService.consultarFatura(id);
        return ResponseEntity.ok(fatura);
    }

    @PostMapping("/{id}/fatura/pagamento")
    public ResponseEntity<Void> pagarFatura(
            @PathVariable Long id,
            @RequestParam BigDecimal valor) {
        cartaoService.pagarFatura(id, valor);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/limite-diario")
    public ResponseEntity<Void> alterarLimiteDiario(
            @PathVariable Long id,
            @RequestParam BigDecimal novoLimiteDiario) {
        cartaoService.alterarLimiteDiario(id, novoLimiteDiario);
        return ResponseEntity.ok().build();
    }
}