package com.example.BancoDigitalAPI.BancoDigitalAPI.exception;

public class ContaNaoEncontradaException extends RuntimeException {
    public ContaNaoEncontradaException(Long id) {
        super("Conta não encontrada com ID: " + id);
    }
}