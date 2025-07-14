package com.example.BancoDigitalAPI.BancoDigitalAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String cvv;
    private String senha;
    private boolean ativo;
    private BigDecimal limite;
    private BigDecimal limiteDiario;
    private TipoCartao tipo;
    private Long contaId;
    private BigDecimal faturaAtual;

    public enum TipoCartao {
        DEBITO, CREDITO
    }

    public Cartao() {
        this.ativo = true;
    }

//    public Cartao(Long id, String numero, String cvv, String senha, TipoCartao tipo, Long contaId) {
//        this();
//        this.id = id;
//        this.numero = numero;
//        this.cvv = cvv;
//        this.senha = senha;
//        this.tipo = tipo;
//        this.contaId = contaId;
//
//    }


    public Cartao(Long id, String numero, String cvv, String senha, boolean ativo, BigDecimal limite, BigDecimal limiteDiario, TipoCartao tipo, Long contaId, BigDecimal faturaAtual) {
        this.id = id;
        this.numero = numero;
        this.cvv = cvv;
        this.senha = senha;
        this.ativo = ativo;
        this.limite = limite;
        this.limiteDiario = limiteDiario;
        this.tipo = tipo;
        this.contaId = contaId;
        this.faturaAtual = faturaAtual;
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

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public BigDecimal getLimiteDiario() {
        return limiteDiario;
    }

    public void setLimiteDiario(BigDecimal limiteDiario) {
        this.limiteDiario = limiteDiario;
    }

    public TipoCartao getTipo() {
        return tipo;
    }

    public void setTipo(TipoCartao tipo) {
        this.tipo = tipo;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public BigDecimal getFaturaAtual() {
        return faturaAtual;
    }

    public void setFaturaAtual(BigDecimal faturaAtual) {
        this.faturaAtual = faturaAtual;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Cartao cartao = (Cartao) o;
//        return Objects.equals(id, cartao.id) &&
//                Objects.equals(numero, cartao.numero);
//    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cartao cartao = (Cartao) o;
        return ativo == cartao.ativo && Objects.equals(id, cartao.id) && Objects.equals(numero, cartao.numero) && Objects.equals(cvv, cartao.cvv) && Objects.equals(senha, cartao.senha) && Objects.equals(limite, cartao.limite) && Objects.equals(limiteDiario, cartao.limiteDiario) && tipo == cartao.tipo && Objects.equals(contaId, cartao.contaId) && Objects.equals(faturaAtual, cartao.faturaAtual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero);
    }

//    @Override
//    public String toString() {
//        return "Cartao{" +
//                "id=" + id +
//                ", numero='" + numero + '\'' +
//                ", cvv='" + cvv + '\'' +
//                ", ativo=" + ativo +
//                ", limite=" + limite +
//                ", limiteDiario=" + limiteDiario +
//                ", tipo=" + tipo +
//                ", contaId=" + contaId +
//                '}';
//    }


    @Override
    public String toString() {
        return "Cartao{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", cvv='" + cvv + '\'' +
                ", senha='" + senha + '\'' +
                ", ativo=" + ativo +
                ", limite=" + limite +
                ", limiteDiario=" + limiteDiario +
                ", tipo=" + tipo +
                ", contaId=" + contaId +
                ", faturaAtual=" + faturaAtual +
                '}';
    }
}