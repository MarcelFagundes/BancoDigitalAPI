package com.example.BancoDigitalAPI.BancoDigitalAPI.repository;

import com.example.BancoDigitalAPI.BancoDigitalAPI.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {}
