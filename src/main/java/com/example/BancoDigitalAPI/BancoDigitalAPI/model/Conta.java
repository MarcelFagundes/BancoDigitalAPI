package com.example.BancoDigitalAPI.BancoDigitalAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String agencia;
    private BigDecimal saldo;
    private TipoConta tipo;
    private Long clienteId;
    private boolean ativa;

    public enum TipoConta {
        CORRENTE, POUPANCA
    }

    public Conta() {
        this.saldo = BigDecimal.ZERO;
        this.ativa = true;
    }

    public Conta(Long id, String numero, String agencia, TipoConta tipo, Long clienteId) {
        this();
        this.id = id;
        this.numero = numero;
        this.agencia = agencia;
        this.tipo = tipo;
        this.clienteId = clienteId;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(id, conta.id) &&
                Objects.equals(numero, conta.numero) &&
                Objects.equals(agencia, conta.agencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, agencia);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", agencia='" + agencia + '\'' +
                ", saldo=" + saldo +
                ", tipo=" + tipo +
                ", clienteId=" + clienteId +
                ", ativa=" + ativa +
                '}';
    }
}