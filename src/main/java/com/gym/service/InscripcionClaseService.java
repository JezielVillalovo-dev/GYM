package com.gym.service;

import com.gym.entity.InscripcionClase;
import com.gym.repository.InscripcionClaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InscripcionClaseService {
    private final InscripcionClaseRepository repository;


    public List<InscripcionClase> listar() {
        return repository.findAll();
    }

    public InscripcionClase obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "InscripcionClase no encontrado"));
    }

    public InscripcionClase crear(InscripcionClase datos) {
        datos.setId(null);
        return repository.save(datos);
    }

    public InscripcionClase actualizar(Long id, InscripcionClase datos) {
        obtenerPorId(id);
        datos.setId(id);
        return repository.save(datos);
    }

    public void eliminar(Long id) {
        InscripcionClase existente = obtenerPorId(id);
        repository.delete(existente);
    }

}
