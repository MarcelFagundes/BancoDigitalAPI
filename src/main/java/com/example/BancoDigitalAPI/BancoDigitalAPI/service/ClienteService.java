package com.example.BancoDigitalAPI.BancoDigitalAPI.service;

import com.example.BancoDigitalAPI.BancoDigitalAPI.model.Cliente;
import com.example.BancoDigitalAPI.BancoDigitalAPI.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente) {
        // Validações e lógica de negócio aqui
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        Cliente clienteExistente = buscarPorId(id);
        // Atualizar campos
        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setTelefone(cliente.getTelefone());
        clienteExistente.setEndereco(cliente.getEndereco());
        return clienteRepository.save(clienteExistente);
    }

    public void remover(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
}