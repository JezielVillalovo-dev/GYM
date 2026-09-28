package com.gym.controller;


import com.gym.entity.Entrenador;
import com.gym.service.EntrenadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EntrenadorController {
    private final EntrenadorService service;
    @GetMapping
    public List<Entrenador> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Entrenador obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrenador crear(@RequestBody Entrenador datos) {
        return service.crear(datos);
    }

    @PutMapping("/{id}")
    public Entrenador actualizar(@PathVariable Long id, @RequestBody Entrenador datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

}
