//package com.example.BancoDigitalAPI.BancoDigitalAPI.model;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.Objects;
//
//public class Seguro {
//    private Long id;
//    private String apolice;
//    private String tipo;
//    private BigDecimal valor;
//    private BigDecimal premio;
//    private LocalDate dataContratacao;
//    private LocalDate dataVencimento;
//    private boolean ativo;
//    private Long clienteId;
//
//    public Seguro() {
//        this.dataContratacao = LocalDate.now();
//        this.ativo = true;
//    }
//
//    public Seguro(Long id, String apolice, String tipo, BigDecimal valor, BigDecimal premio,
//                  LocalDate dataVencimento, Long clienteId) {
//        this();
//        this.id = id;
//        this.apolice = apolice;
//        this.tipo = tipo;
//        this.valor = valor;
//        this.premio = premio;
//        this.dataVencimento = dataVencimento;
//        this.clienteId = clienteId;
//    }
//
//    // Getters e Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getApolice() {
//        return apolice;
//    }
//
//    public void setApolice(String apolice) {
//        this.apolice = apolice;
//    }
//
//    public String getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(String tipo) {
//        this.tipo = tipo;
//    }
//
//    public BigDecimal getValor() {
//        return valor;
//    }
//
//    public void setValor(BigDecimal valor) {
//        this.valor = valor;
//    }
//
//    public BigDecimal getPremio() {
//        return premio;
//    }
//
//    public void setPremio(BigDecimal premio) {
//        this.premio = premio;
//    }
//
//    public LocalDate getDataContratacao() {
//        return dataContratacao;
//    }
//
//    public void setDataContratacao(LocalDate dataContratacao) {
//        this.dataContratacao = dataContratacao;
//    }
//
//    public LocalDate getDataVencimento() {
//        return dataVencimento;
//    }
//
//    public void setDataVencimento(LocalDate dataVencimento) {
//        this.dataVencimento = dataVencimento;
//    }
//
//    public boolean isAtivo() {
//        return ativo;
//    }
//
//    public void setAtivo(boolean ativo) {
//        this.ativo = ativo;
//    }
//
//    public Long getClienteId() {
//        return clienteId;
//    }
//
//    public void setClienteId(Long clienteId) {
//        this.clienteId = clienteId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Seguro seguro = (Seguro) o;
//        return Objects.equals(id, seguro.id) &&
//                Objects.equals(apolice, seguro.apolice);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, apolice);
//    }
//
//    @Override
//    public String toString() {
//        return "Seguro{" +
//                "id=" + id +
//                ", apolice='" + apolice + '\'' +
//                ", tipo='" + tipo + '\'' +
//                ", valor=" + valor +
//                ", premio=" + premio +
//                ", dataContratacao=" + dataContratacao +
//                ", dataVencimento=" + dataVencimento +
//                ", ativo=" + ativo +
//                ", clienteId=" + clienteId +
//                '}';
//    }
//}