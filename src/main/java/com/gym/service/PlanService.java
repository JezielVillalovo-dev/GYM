package com.gym.service;

import com.gym.entity.Plan;
import com.gym.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository repository;

    public List<Plan> listar() {
        return repository.findAll();
    }

    public Plan obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Plan no encontrado"));
    }

    public Plan crear(Plan datos) {
        datos.setId(null);
        return repository.save(datos);
    }

    public Plan actualizar(Long id, Plan datos) {
        obtenerPorId(id);
        datos.setId(id);
        return repository.save(datos);
    }

    public void eliminar(Long id) {
        Plan existente = obtenerPorId(id);
        repository.delete(existente);
    }
}
