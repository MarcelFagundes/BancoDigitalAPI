package com.example.BancoDigitalAPI.BancoDigitalAPI.service;

import com.example.BancoDigitalAPI.BancoDigitalAPI.model.Cartao;
import com.example.BancoDigitalAPI.BancoDigitalAPI.model.Conta;
import com.example.BancoDigitalAPI.BancoDigitalAPI.model.Transacao;
import com.example.BancoDigitalAPI.BancoDigitalAPI.repository.CartaoRepository;
import com.example.BancoDigitalAPI.BancoDigitalAPI.repository.ContaRepository;
import com.example.BancoDigitalAPI.BancoDigitalAPI.repository.TransacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class CartaoService {

    private final CartaoRepository cartaoRepository;
    private final ContaRepository contaRepository;
    private final TransacaoRepository transacaoRepository;

    public CartaoService(CartaoRepository cartaoRepository,
                         ContaRepository contaRepository,
                         TransacaoRepository transacaoRepository) {
        this.cartaoRepository = cartaoRepository;
        this.contaRepository = contaRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @Transactional
    public void realizarPagamento(Long id, BigDecimal valor, String senha) {
        Cartao cartao = buscarPorId(id);

        validarPagamento(cartao, valor, senha);

        if (cartao.getTipo() == Cartao.TipoCartao.DEBITO) {
            debitarDaConta(cartao, valor);
        } else {
            atualizarFaturaCredito(cartao, valor);
        }

        cartaoRepository.save(cartao);
        registrarTransacao(cartao, valor);
    }

    private void validarPagamento(Cartao cartao, BigDecimal valor, String senha) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser positivo");
        }

        if (!cartao.getSenha().equals(senha)) {
            throw new SecurityException("Senha incorreta");
        }

        if (!cartao.isAtivo()) {
            throw new IllegalStateException("Cartão inativo");
        }
    }

    private void debitarDaConta(Cartao cartao, BigDecimal valor) {
        Conta conta = contaRepository.findById(cartao.getContaId())
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        if (cartao.getLimiteDiario() != null &&
                valor.compareTo(cartao.getLimiteDiario()) > 0) {
            throw new IllegalStateException("Valor excede o limite diário");
        }

        if (conta.getSaldo().compareTo(valor) < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        }

        conta.setSaldo(conta.getSaldo().subtract(valor));
        contaRepository.save(conta);
    }

    private void atualizarFaturaCredito(Cartao cartao, BigDecimal valor) {
        if (cartao.getLimite().compareTo(valor) < 0) {
            throw new IllegalStateException("Limite insuficiente");
        }

        cartao.setLimite(cartao.getLimite().subtract(valor));

        // Atualizar fatura atual
        BigDecimal faturaAtual = cartao.getFaturaAtual() != null ?
                cartao.getFaturaAtual() : BigDecimal.ZERO;
        cartao.setFaturaAtual(faturaAtual.add(valor));
    }

    private void registrarTransacao(Cartao cartao, BigDecimal valor) {
        Transacao transacao = new Transacao();
        transacao.setCartaoId(cartao.getId());
        transacao.setValor(valor);
        transacao.setData(LocalDateTime.now());
        transacao.setTipo(cartao.getTipo() == Cartao.TipoCartao.DEBITO ?
                "PAGAMENTO_DEBITO" : "PAGAMENTO_CREDITO");
        transacaoRepository.save(transacao);
    }

    public Cartao buscarPorId(Long id) {
        return cartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));
    }

    public Cartao salvar(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

    public void alterarLimite(Long id, BigDecimal novoLimite) {
        Cartao cartao = buscarPorId(id);
        cartao.setLimite(novoLimite);
        cartaoRepository.save(cartao);
    }

    public void alterarStatus(Long id, boolean ativo) {
        Cartao cartao = buscarPorId(id);
        cartao.setAtivo(ativo);
        cartaoRepository.save(cartao);
    }

    public void alterarSenha(Long id, String novaSenha) {
        Cartao cartao = buscarPorId(id);
        cartao.setSenha(novaSenha);
        cartaoRepository.save(cartao);
    }

    public BigDecimal consultarFatura(Long id) {
        Cartao cartao = buscarPorId(id);
        if (cartao.getTipo() == Cartao.TipoCartao.CREDITO) {
            return cartao.getLimite().subtract(cartao.getFaturaAtual());
        }
        throw new RuntimeException("Cartão não é de crédito");
    }

    public void pagarFatura(Long id, BigDecimal valor) {
        Cartao cartao = buscarPorId(id);
        if (cartao.getTipo() == Cartao.TipoCartao.CREDITO) {
            cartao.setLimite(cartao.getLimite().add(valor));
            cartaoRepository.save(cartao);
        } else {
            throw new RuntimeException("Cartão não é de crédito");
        }
    }

    public void alterarLimiteDiario(Long id, BigDecimal novoLimiteDiario) {
        Cartao cartao = buscarPorId(id);
        if (cartao.getTipo() == Cartao.TipoCartao.DEBITO) {
            cartao.setLimiteDiario(novoLimiteDiario);
            cartaoRepository.save(cartao);
        } else {
            throw new RuntimeException("Apenas cartões de débito possuem limite diário");
        }
    }
}