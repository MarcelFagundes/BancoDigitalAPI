package com.example.BancoDigitalAPI.BancoDigitalAPI.repository;

import com.example.BancoDigitalAPI.BancoDigitalAPI.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {}