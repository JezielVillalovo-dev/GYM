package com.gym.service;

import com.gym.entity.Entrenador;
import com.gym.repository.EntrenadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntrenadorService {
    private final EntrenadorRepository repository;

    public List<Entrenador> listar() {
        return repository.findAll();
    }

    public Entrenador obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Entrenador no encontrado"));
    }

    public Entrenador crear(Entrenador datos) {
        datos.setId(null);
        return repository.save(datos);
    }

    public Entrenador actualizar(Long id, Entrenador datos) {
        obtenerPorId(id);
        datos.setId(id);
        return repository.save(datos);
    }

    public void eliminar(Long id) {
        Entrenador existente = obtenerPorId(id);
        repository.delete(existente);
    }


}
