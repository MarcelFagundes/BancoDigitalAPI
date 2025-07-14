package com.example.BancoDigitalAPI.BancoDigitalAPI.service;

import com.example.BancoDigitalAPI.BancoDigitalAPI.model.Conta;
import com.example.BancoDigitalAPI.BancoDigitalAPI.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta salvar(Conta conta) {
        return contaRepository.save(conta);
    }

    public Conta buscarPorId(Long id) {
        return contaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    public void transferir(Long contaOrigemId, Long contaDestinoId, BigDecimal valor) {
        Conta origem = buscarPorId(contaOrigemId);
        Conta destino = buscarPorId(contaDestinoId);

        if (origem.getSaldo().compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        origem.setSaldo(origem.getSaldo().subtract(valor));
        destino.setSaldo(destino.getSaldo().add(valor));

        contaRepository.save(origem);
        contaRepository.save(destino);
    }

    public BigDecimal consultarSaldo(Long id) {
        return buscarPorId(id).getSaldo();
    }

    public void realizarPix(Long contaId, String chavePix, BigDecimal valor) {
        // Implementação simplificada - similar à transferência
        Conta conta = buscarPorId(contaId);

        if (conta.getSaldo().compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        conta.setSaldo(conta.getSaldo().subtract(valor));
        contaRepository.save(conta);
    }

    public void depositar(Long id, BigDecimal valor) {
        Conta conta = buscarPorId(id);
        conta.setSaldo(conta.getSaldo().add(valor));
        contaRepository.save(conta);
    }

    public void sacar(Long id, BigDecimal valor) {
        Conta conta = buscarPorId(id);

        if (conta.getSaldo().compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        conta.setSaldo(conta.getSaldo().subtract(valor));
        contaRepository.save(conta);
    }

    public void aplicarTaxaManutencao(Long id) {
        Conta conta = buscarPorId(id);
        if (conta.getTipo() == Conta.TipoConta.CORRENTE) {
            BigDecimal taxa = new BigDecimal("10.00"); // Taxa fixa de exemplo
            conta.setSaldo(conta.getSaldo().subtract(taxa));
            contaRepository.save(conta);
        }
    }

    public void aplicarRendimentos(Long id) {
        Conta conta = buscarPorId(id);
        if (conta.getTipo() == Conta.TipoConta.POUPANCA) {
            BigDecimal rendimento = conta.getSaldo().multiply(new BigDecimal("0.005")); // 0.5% de exemplo
            conta.setSaldo(conta.getSaldo().add(rendimento));
            contaRepository.save(conta);
        }
    }
}