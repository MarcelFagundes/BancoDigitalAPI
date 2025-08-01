package com.example.BancoDigitalAPI.BancoDigitalAPI.repository;

import com.example.BancoDigitalAPI.BancoDigitalAPI.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {}