package com.example.BancoDigitalAPI.BancoDigitalAPI.exception;

import java.math.BigDecimal;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(BigDecimal saldoAtual, BigDecimal valorSaque) {
        super(String.format("Saldo insuficiente. Saldo atual: %.2f, Valor solicitado: %.2f",
                saldoAtual, valorSaque));
    }
}