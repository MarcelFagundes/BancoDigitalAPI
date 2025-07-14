package com.example.BancoDigitalAPI.BancoDigitalAPI.repository;

import com.example.BancoDigitalAPI.BancoDigitalAPI.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}