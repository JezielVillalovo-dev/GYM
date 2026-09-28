package com.gym.controller;

import com.gym.entity.Plan;
import com.gym.repository.PlanRepository;
import com.gym.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class PlanController {
    private final PlanService service;

    @GetMapping
    public List<Plan> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Plan obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Plan crear(@RequestBody Plan datos) {
        return service.crear(datos);
    }

    @PutMapping("/{id}")
    public Plan actualizar(@PathVariable Long id, @RequestBody Plan datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

}
