package com.gym.service;

import com.gym.entity.Clases;
import com.gym.repository.ClasesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClaseService {
    private final ClasesRepository repository;

    public List<Clases> listar() {
        return repository.findAll();
    }

    public Clases obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Clase no encontrado"));
    }

    public Clases crear(Clases datos) {
        datos.setId(null);
        return repository.save(datos);
    }

    public Clases actualizar(Long id, Clases datos) {
        obtenerPorId(id);
        datos.setId(id);
        return repository.save(datos);
    }

    public void eliminar(Long id) {
        Clases existente = obtenerPorId(id);
        repository.delete(existente);
    }

}
