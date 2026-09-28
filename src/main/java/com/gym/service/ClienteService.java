package com.gym.service;

import com.gym.entity.Cliente;
import com.gym.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cliente no encontrado"));
    }

    public Cliente crear(Cliente datos) {
        datos.setId(null);
        return clienteRepository.save(datos);
    }

    public Cliente actualizar(Long id, Cliente datos) {
        obtenerPorId(id);
        datos.setId(id);
        return clienteRepository.save(datos);
    }

    public void eliminar(Long id) {
        Cliente existente = obtenerPorId(id);
        clienteRepository.delete(existente);

    }
}
