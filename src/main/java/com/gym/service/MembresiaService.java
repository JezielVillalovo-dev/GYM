package com.gym.service;

import com.gym.entity.Membresia;
import com.gym.repository.MembresiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembresiaService {
    private final MembresiaRepository repository;
    public List<Membresia> listar() {
        return repository.findAll();
    }

    public Membresia obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Membresia no encontrado"));
    }

    public Membresia crear(Membresia datos) {
        datos.setId(null);
        return repository.save(datos);
    }

    public Membresia actualizar(Long id, Membresia datos) {
        obtenerPorId(id);
        datos.setId(id);
        return repository.save(datos);
    }

    public void eliminar(Long id) {
        Membresia existente = obtenerPorId(id);
        repository.delete(existente);
    }
}
